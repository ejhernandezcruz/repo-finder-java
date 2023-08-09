package com.truenorth.repofinder.pages;


import com.truenorth.repofinder.utils.Config;
import com.truenorth.repofinder.utils.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


@Slf4j
public class BasePage {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public BasePage() {
        Duration duration = Duration.ofSeconds(Config.getTimeout());
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, duration);
        this.wait.ignoring(NoSuchElementException.class);
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    //NAVIGATE METHODS
    public void navigateTo(String url) {
        driver.get(url);
    }

    //WAIT METHODS
    protected void waitExpectedConditions(ExpectedCondition<?> condition) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected void waitForVisibility(WebElement element) {
        waitExpectedConditions(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAllElementsVisibility(List<WebElement> elements){
        waitExpectedConditions(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForClickable(WebElement element) {
        waitExpectedConditions(ExpectedConditions.elementToBeClickable(element));
    }


    protected void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void waitAndClick(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        element.click();

    }



}
