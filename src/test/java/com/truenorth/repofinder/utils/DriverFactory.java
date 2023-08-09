package com.truenorth.repofinder.utils;


import org.openqa.selenium.WebDriver;

import static com.truenorth.repofinder.constants.Browser.*;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver;
        Drivers drivers = new Drivers();
        driver = switch (Config.getBrowser()) {
            case CHROME -> drivers.chrome();
            case FIREFOX -> drivers.firefox();
            default -> throw new RuntimeException("Browser not supported!");
        };
        driver.manage().window().maximize();
        return driver;
    }


    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
