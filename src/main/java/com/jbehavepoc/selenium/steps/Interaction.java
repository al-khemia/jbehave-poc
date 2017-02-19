package com.jbehavepoc.selenium.steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by linfante on 2/17/2017.
 */
public class  Interaction {

    private WebDriver driver;
    private Point initial_point;
    private WebElement dragBox_we;
    private String url;
    private String dropBox_text;

    @BeforeStories
    public void beforeStories() {
        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", "C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Marionette\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I open $browser_url")
    public void givenIOpenurl(String browser_url) {
        url = browser_url;
        driver.get(browser_url);
    }

    @When("I drag a box $x to the right and $y below")
    public void whenIDragABox(Integer x, Integer y) {
        dragBox_we = driver.findElement(By.id("draggable"));
        initial_point = dragBox_we.getLocation();

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragBox_we, x, y).perform();
    }

    @When("I drag a box with a target")
    public void thenIDragABoxWithATarget() {
        dragBox_we = driver.findElement(By.id("draggableview"));
        dropBox_text = driver.findElement(By.id("droppableview")).getText();

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragBox_we, 150, 40).perform();
    }

    @Then("The box has changed the position")
    public void thenTheBoxHasChangedThePosition() {
        Assert.assertNotEquals("Box hasn´t changed position", initial_point, dragBox_we.getLocation());
    }

    @Then("Target has changed its text")
    public void thenTargetHasChangedItsText() {
        Assert.assertNotEquals("Box hasn´t changed text", dropBox_text, driver.findElement(By.id("droppableview")).getText());
    }
}


