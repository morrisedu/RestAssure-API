package com.cydeo.steps_definitions;

import com.cydeo.utility.DB_Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.cydeo.utility.ConfigReader.confRead;
import static com.cydeo.utility.Driver.*;

/**
 * Hook class contains methods that run before &/or after each scenario
 * With tags, you can run certain code before & after each scenario that is tagged with a particular tag
 */
public class Hooks {
    @Before("@web-ui")
    public void setupDriver() {
        // Setup implicit wait
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        // This is deprecated getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window size
        getDriver().manage().window().maximize();
    }

    @After("@web-ui")
    public void tearDown(Scenario scenario) {


        // Taking screenshot if scenario is failed
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Close browser
        closeBrowser();
    }

    @Before("@db")
    public void setupConnection() {
        String url = confRead("hr.database.url"),
                username = confRead("hr.database.username"),
                password = confRead("hr.database.password");

        DB_Util.createConnection(url, username, password);
    }

    @After("@db")
    public void teardown() {
        DB_Util.destroy();
    }
}