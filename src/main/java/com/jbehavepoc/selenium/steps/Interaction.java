package com.jbehavepoc.selenium.steps;

import com.jbehavepoc.utils.InteractionUtils;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by linfante on 2/17/2017.
 */
public class Interaction {

    private WebDriver driver;
    private Point initial_point;
    private Point initial_pointR;
    private WebElement dragBox_we;
    private WebElement dragBoxR_we;
    private WebElement dragProduct_we;
    private WebElement cart_we;
    private String url;
    private String dropBox_text;
    private String dropBoxR_text;

    @BeforeStories
    public void beforeStories() {
        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", "C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Marionette\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    @Given("I open $browser_url")
    public void givenIOpenurl(String browser_url) {
        url = browser_url;
        driver.get(browser_url);
    }

    @Given("I go to $textLink")
    public void givenIGoToRevertDraggablePosition(String textLink) {
        driver.findElement(By.linkText(textLink)).click();
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

    @When("I move the box to the target")
    public void whenIMoveTheBoxToTheTarget() {

        dragBoxR_we = driver.findElement(By.id("draggablerevert"));
        initial_pointR = dragBoxR_we.getLocation();
        dropBoxR_text = driver.findElement(By.id("droppablerevert")).getText();

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragBoxR_we, 230, 0).perform();
    }

    @Then("The box has changed the position")
    public void thenTheBoxHasChangedThePosition() {
        Assert.assertNotEquals("Box hasn´t changed position", initial_point, dragBox_we.getLocation());
    }

    @Then("Target has changed its text")
    public void thenTargetHasChangedItsText() {
        Assert.assertNotEquals("Box hasn´t changed text", dropBox_text, driver.findElement(By.id("droppableview")).getText());
    }

    @Then("Box reverts after dropping")
    public void thenBoxRevertsAfterDropping() throws InterruptedException {
        Assert.assertNotEquals("Box hasn´t changed text", dropBoxR_text, driver.findElement(By.id("droppablerevert")).getText());
        //org.jbehave.core.embedder.Embedder$RunningStoriesFailed
        Thread.sleep(3000);
        Assert.assertEquals("Box has not returned", initial_pointR, dragBoxR_we.getLocation());

    }

    @When("I add products [products]")
    public void whenIAddProducts(@Named("products") List<String> productsList) throws InterruptedException {
        cart_we = driver.findElement(By.cssSelector("li.placeholder.ui-corner-left"));
        InteractionUtils utils = new InteractionUtils();
        Actions builder = new Actions(driver);

        for (int i = 0; i < productsList.size(); i++) {
            driver.findElement(By.linkText(utils.getCategoryName(productsList.get(i)))).click();
            Thread.sleep(3000);
            dragProduct_we = driver.findElement(By.xpath(utils.getProductSelector(productsList.get(i))));
            builder.dragAndDrop(dragProduct_we, cart_we).perform();
        }
    }

    @Then("My shopping car has items")
    @Pending
    public void thenMyShoppingCarHasItems() {
        // PENDING
    }

}


