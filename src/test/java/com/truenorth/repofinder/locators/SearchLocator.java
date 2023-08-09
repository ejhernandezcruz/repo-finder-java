package com.truenorth.repofinder.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchLocator {

    @FindBy(tagName = "h1")
    public WebElement header;

    @FindBy(id = "username")
    public WebElement usernameText;

    @FindBy(className = "submit")
    public WebElement goButton;

    @FindBy(className = "output-status-text")
    public WebElement outputStatusLabel;

    @FindBy(css = "li[class='repo-row']")
    public List<WebElement> repoRows;

    @FindBy(css = "a[rel='noopener noreferrer']")
    public List<WebElement> repoNameList;

    @FindBy(className = "repo-description")
    public List<WebElement> repoDescriptionList;



}
