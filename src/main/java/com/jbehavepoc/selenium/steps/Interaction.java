package com.jbehavepoc.selenium.steps;

import com.jbehavepoc.utils.RegistrationUtils;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by linfante on 2/17/2017.
 */
public class Interaction {

    public WebDriver driver;
    public RegistrationUtils utils;

    @BeforeStories
    public void beforeStories() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I open $url")
    public void givenIOpenurl(String url) {
        //Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        //Chrome driver
        //System.setProperty("webdriver.chrome.driver", "C:\\Marionette\\chromedriver_win32\\chromedriver.exe");
        driver.get(url);
    }
}
