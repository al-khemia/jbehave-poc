package com.jbehavepoc.selenium.steps;

import com.jbehavepoc.utils.UtilsSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

/**
 * Created by linfante on 2/7/2017.
 */
public class RegistrationInDemoQASteps {

    public WebDriver driver;
    public UtilsSteps utils;

    @Given("I open $url")
    public void givenIOpenurl(String url) {
        //System.setProperty("webdriver.gecko.driver","C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("I fill the registration form")
    public void whenIFillTheRegistrationForm() {
        //Firstname and Lastname
        driver.findElement(By.xpath("id('name_3_firstname')")).sendKeys("Lina");
        driver.findElement(By.id("name_3_lastname")).sendKeys("Infante");

        //Radiobutton marital status
        driver.findElement(By.cssSelector("[name='radio_4[]'][value='single'][type='radio']")).click();

        //Checkbox hobby
        driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='dance'][type='checkbox']")).click();
        driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='reading'][type='checkbox']")).click();
        driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='cricket '][type='checkbox']")).click();

        //Choosing Colombia as country Dropdown
        WebElement country_dd = driver.findElement(By.id("dropdown_7"));
        Select country_select = new Select(country_dd);
        country_select.selectByValue("Colombia");

        //Choosing Date of Birth
        WebElement month_dd = driver.findElement(By.id("mm_date_8"));
        Select month_select = new Select(month_dd);
        month_select.selectByValue("10");

        WebElement day_dd = driver.findElement(By.id("dd_date_8"));
        Select day_select = new Select(day_dd);
        day_select.selectByValue("22");

        WebElement year_dd = driver.findElement(By.id("yy_date_8"));
        Select year_select = new Select(year_dd);
        year_select.selectByValue("1986");

        //Enter a valid phone number
        driver.findElement(By.id("phone_9")).sendKeys("57315613790");

        //Enter a username
        driver.findElement(By.id("username")).sendKeys(utils.randomUser());

        //Enter an email
        driver.findElement(By.id("email_1")).sendKeys(utils.randomUser()+"@example.com");

        //Loading a pic

        //Enter bio
        driver.findElement(By.id("description")).sendKeys("If you are applying for a position such as a member on a team of scientists that will travel to the Arctic together, you would want to list interests that show you are an adventurous team player. Things like, soccer player, rock climber, hiker, etc. would work well.");

        //Enter password
        driver.findElement(By.id("password_2")).sendKeys("6;78Z9cW");

        //Enter password confirmation
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("6;78Z9cW");

    }

    @When("I submit the registration form")
    public void whenISubmitTheRegistrationForm() {
        //Submit form
        driver.findElement(By.name("pie_submit")).click();

    }

    @Then("$msg message is displayed")
    public void thenAMessageIsDisplayed(String msg) {
        //Assertion of message
        Assert.assertEquals(driver.findElement(By.cssSelector("p.piereg_message")).getText(),msg);
    }

    @Then("$msg Error messages are displayed")
    public void thenErrorMessagesAreDisplayed(String msg) {
        Assert.assertEquals(driver.findElement(By.cssSelector("span.legend.error")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[3]/div/div[2]/span")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[6]/div/div/span")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[7]/div/div/span")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[8]/div/div/span")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[11]/div/div/span")).getText(),msg);
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='pie_register']/li[12]/div/div/span")).getText(),msg);
    }

}
