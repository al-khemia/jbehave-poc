package com.jbehavepoc.selenium.steps;

import com.jbehavepoc.utils.UtilsSteps;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


/**
 * Created by linfante on 2/7/2017.
 */
public class RegistrationInDemoQASteps {

    public WebDriver driver;
    public UtilsSteps utils;

    @BeforeStories
    public void beforeStories(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I open $url")
    public void givenIOpenurl(String url) {
        System.setProperty("webdriver.gecko.driver","C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        driver.get(url);
    }

    @When("I enter [firstname] and [lastname]")
    public void iEnterFirstnameAndLastname(@Named("firstname") String firstname, @Named("lastname") String lastname) {
        //Firstname and Lastname
        driver.findElement(By.xpath("id('name_3_firstname')")).sendKeys(firstname);
        driver.findElement(By.id("name_3_lastname")).sendKeys(lastname);
    }

    @When("I choose [maritalStatus]")
    public void whenIChoosemaritalStatus(@Named("maritalStatus") String m_status) {
        //Radiobutton marital status
        driver.findElement(By.cssSelector("[name='radio_4[]'][value='"+m_status+"'][type='radio']")).click();
    }

    @When("I like to [dance], [reading] and [cricket]")
    public void whenIChoosehobbie(@Named("dance") Boolean dance, @Named("reading") Boolean reading, @Named("cricket") Boolean cricket) {

        System.out.print("I like to execute the step"+dance+reading+cricket);
        //Checkbox hobby
        if (dance==Boolean.TRUE){
            driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='dance'][type='checkbox']")).click();
            System.out.print("dancign al kdjfldskjfldskjf "+dance);
        }

        if (reading==Boolean.TRUE){
            driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='reading'][type='checkbox']")).click();
        }

        if(cricket==Boolean.TRUE){
            driver.findElement(By.cssSelector("[name='checkbox_5[]'][value='cricket '][type='checkbox']")).click();
        }
    }

    @When("I select [country]")
    public void whenISelectcountry(@Named("country") String country) {
        //Choosing Colombia as country Dropdown
        WebElement country_dd = driver.findElement(By.id("dropdown_7"));
        Select country_select = new Select(country_dd);
        country_select.selectByValue(country);
    }

    @When("I select Date of Birth [dd] [mm] [aaaa]")
    public void whenISelectDateOfBirthddmmaaaa(@Named("dd") String dd, @Named("mm") String mm, @Named("aaaa") String aaaa) {
        //Choosing Date of Birth
        WebElement month_dd = driver.findElement(By.id("mm_date_8"));
        Select month_select = new Select(month_dd);
        month_select.selectByValue(mm);

        WebElement day_dd = driver.findElement(By.id("dd_date_8"));
        Select day_select = new Select(day_dd);
        day_select.selectByValue(dd);

        WebElement year_dd = driver.findElement(By.id("yy_date_8"));
        Select year_select = new Select(year_dd);
        year_select.selectByValue(aaaa);
    }

    @When("I enter [username]")
    public void whenIEnterusername(@Named("username") String username) {
        //Enter a random username or username entered by story
        if(username.isEmpty()){
            driver.findElement(By.id("username")).sendKeys(UtilsSteps.randomUser());
            System.out.print("is empty username"+username);
        }else{
            driver.findElement(By.id("username")).sendKeys(username);
        }

    }

    @When("I enter [email]")
    public void whenIEnteremail(@Named("email") String email) {
        //Enter a random email or email entered by story
        if(email.isEmpty()){
            driver.findElement(By.id("email_1")).sendKeys(UtilsSteps.randomUser()+"@example.com");
            System.out.print("is empty email"+email);
        }else {
            driver.findElement(By.id("email_1")).sendKeys(email);
        }
    }

    @When("I enter a bio")
    public void whenIEnterABio() {
        //Enter bio
        driver.findElement(By.id("description")).sendKeys("If you are applying for a position such as a member on a team of scientists that will travel to the Arctic together, you would want to list interests that show you are an adventurous team player. Things like, soccer player, rock climber, hiker, etc. would work well.");

    }

    @When("I enter this [password]")
    public void iEnterThisPassword(@Named("password") String password) {
        //Enter password
        driver.findElement(By.id("password_2")).sendKeys(password);

        //Enter password confirmation
        driver.findElement(By.id("confirm_password_password_2")).sendKeys(password);
    }

    @When("I enter confirmation [con_password]")
    public void iEnterConfirmationPassword(@Named("con_password") String con_password) {

        //Enter password confirmation
        driver.findElement(By.id("confirm_password_password_2")).sendKeys(con_password);
    }

    @When("I enter this [phoneNumber]")
    public void iEnterPhoneNumber(@Named("phoneNumber") String phone_num) {

        //Enter a valid phone number
        driver.findElement(By.id("phone_9")).sendKeys(phone_num);
    }

    @When("I submit the registration form")
    public void whenISubmitTheRegistrationForm() {
        //Submit form
        driver.findElement(By.name("pie_submit")).click();

    }

    @Then("A [message] is displayed")
    public void thenAMessageIsDisplayed(@Named("message") String msg) {
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

    @Then("$msg email message is displayed")
    public void thenEmailMessageIsDisplayed(String msg) {
        //Assertion of message
        Assert.assertEquals(driver.findElement(By.xpath("id('pie_register')/x:li[12]/x:div/x:div/x:span")).getText(),msg);
    }

}