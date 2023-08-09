package com.truenorth.repofinder.stepdefinitions.search;

import com.google.gson.JsonObject;
import com.truenorth.repofinder.pages.SearchPage;
import com.truenorth.repofinder.utils.JsonReaderUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public class SearchRepoSteps {

    @Getter @Setter
    private String username;

    private final SearchPage searchPage;

    @Before
    public void setTestData() {
        JsonObject jsonObject = JsonReaderUtil.getJsonObject("userData.json");
        String username = jsonObject.get("username").getAsString();
        setUsername(username);
    }

    @When("I type the Github username of a student into the search form")
    public void i_type_the_github_username_of_a_student_into_the_search_form() {
        searchPage.typeUsername(getUsername());

    }

    @When("press the Go button")
    public void press_the_go_button() {
        searchPage.clickOnGoButton();

    }

    @Then("each repo is displayed as a row in the search result section")
    public void each_repo_is_displayed_as_a_row_in_the_search_result_section() {
        searchPage.verifyRowAreVisible();
    }

    @Then("each row includes the name and description of the repo")
    public void each_row_includes_the_name_and_description_of_the_repo() {
        searchPage.verifyRowResultsContainsNameAndDescription();

    }

    @Then("the repo name is a link to the repo's URL")
    public void the_repo_name_is_a_link_to_the_repo_s_url() {
        searchPage.verifyNotBrokenLinksToRepo();
    }

    @Then("if any information is missing, then {string} is displayed instead")
    public void if_any_information_is_missing_then_is_displayed_instead(String defaultDescriptionValue) {
        searchPage.verifyRepoDescriptionDefaultValue(defaultDescriptionValue);
    }
}
