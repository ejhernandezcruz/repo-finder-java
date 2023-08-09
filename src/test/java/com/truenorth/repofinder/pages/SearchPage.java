package com.truenorth.repofinder.pages;


import com.google.common.truth.Truth;
import com.truenorth.repofinder.locators.SearchLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    private final SearchLocator locator;

    public SearchPage() {
        this.locator = PageFactory.initElements(getDriver(), SearchLocator.class);
    }

    public void typeUsername(String username) {
        sendKeys(locator.usernameText, username);
    }

    public void clickOnGoButton() {
        waitAndClick(locator.goButton);
    }

    public void verifyLayoutComponents(String expectedOutputStatus) {
        waitForVisibility(locator.header);
        waitForVisibility(locator.usernameText);
        waitForVisibility(locator.goButton);
        String currentOutputStatus = locator.outputStatusLabel.getText();
        Truth.assertThat(currentOutputStatus).isEqualTo(expectedOutputStatus);
    }

    public void verifyPageHeader(String expectedHeader) {
        String currentHeader = locator.header.getText();
        Truth.assertThat(currentHeader).isEqualTo(expectedHeader);
    }

    public void verifyRowAreVisible() {
        waitForAllElementsVisibility(locator.repoRows);
    }

    public void verifyRowResultsContainsNameAndDescription() {
        verifyElementTextNotEmpty(locator.repoDescriptionList);
        verifyElementTextNotEmpty(locator.repoNameList);
    }

    private void verifyElementTextNotEmpty(List<WebElement> elements) {
        long count = elements.stream()
                .map(WebElement::getText)
                .filter(String::isEmpty)
                .count();

        Truth.assertThat(count).isEqualTo(0);
    }

    public void verifyNotBrokenLinksToRepo() {
        long count = locator.repoNameList.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(String::isEmpty).count();

        Truth.assertThat(count).isEqualTo(0);
    }

    public void verifyRepoDescriptionDefaultValue(String defaultDescriptionValue) {
        locator.repoDescriptionList.stream()
                .map(element -> element.getText().trim())
                .filter(repoDescription -> repoDescription.length() == 1)
                .forEach(repoDescription -> Truth.assertThat(repoDescription).isEqualTo(defaultDescriptionValue));
    }


}
