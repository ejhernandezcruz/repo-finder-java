package com.truenorth.repofinder.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class Drivers {

    public WebDriver chrome() {
        ChromeOptions options = new ChromeOptions();
        if(Config.getHeadless()) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }


    public WebDriver firefox() {
        FirefoxOptions options =new FirefoxOptions();
        options.setHeadless(Config.getHeadless());
        return new FirefoxDriver(options);
    }


}
