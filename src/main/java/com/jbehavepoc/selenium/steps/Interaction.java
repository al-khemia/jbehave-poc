package com.jbehavepoc.selenium.steps;

import com.jbehavepoc.utils.RegistrationUtils;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by linfante on 2/17/2017.
 */
public class Interaction {

    public WebDriver driver;
    public RegistrationUtils utils;

    @BeforeStories
    public void beforeStories() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I open $url")
    public void givenIOpenurl(String url) {
        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", "C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Marionette\\chromedriver_win32\\chromedriver.exe");
        driver.get(url);
    }

    @When("I drag a box")
    public void whenIDragABox(){
        WebElement box = driver.findElement(By.id("draggable"));

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(box, 500,500).perform();
    }

    @Then("The box has changed the position")
    @Pending
    public void thenTheBoxHasChangedThePosition() {
        // PENDING
    }


}
