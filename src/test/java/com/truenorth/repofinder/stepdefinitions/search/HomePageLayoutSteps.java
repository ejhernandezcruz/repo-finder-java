package com.truenorth.repofinder.stepdefinitions.search;

import com.truenorth.repofinder.data.LayoutData;
import com.truenorth.repofinder.pages.SearchPage;
import com.truenorth.repofinder.utils.Config;
import com.truenorth.repofinder.utils.JsonReaderUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HomePageLayoutSteps {

    private LayoutData layoutData;

    private final SearchPage searchPage;

    @Before
    public void initTestData() {
        this.layoutData = JsonReaderUtil.getObjectFromJson("layout.json", LayoutData.class);
    }

    @Given("I am on the Repo Finder App")
    public void i_am_on_the_repo_finder_app() {
        searchPage.navigateTo(Config.getBaseUrl());
    }

    @Then("I see a UI with a header, a search form, and a search result section")
    public void i_see_a_ui_with_a_header_a_search_form_and_a_search_result_section() {
        searchPage.verifyLayoutComponents(layoutData.getOutput_text_default());

    }

    @Then("the header displays the title of the app")
    public void the_header_displays_the_title_of_the_app() {
        searchPage.verifyPageHeader(layoutData.getHeader_label());
    }
}
