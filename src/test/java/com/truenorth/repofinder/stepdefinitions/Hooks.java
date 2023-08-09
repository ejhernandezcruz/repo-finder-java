package com.truenorth.repofinder.stepdefinitions;

import com.truenorth.repofinder.utils.Config;
import com.truenorth.repofinder.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;


public class Hooks {

    @SneakyThrows
    @Before
    public void setup() {
        Config.loadConfig();
        DriverFactory.getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + timeMilliseconds);

        }
    }

    @After
    public void tearDown() {
        DriverFactory.cleanupDriver();
    }
}
