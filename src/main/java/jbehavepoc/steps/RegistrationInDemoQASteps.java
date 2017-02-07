package jbehavepoc.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by linfante on 2/7/2017.
 */
public class RegistrationInDemoQASteps {

    public WebDriver driver;

    @Given("I open $url")
    public void givenIOpenHttpdemoqacomregistration(String url) {
        System.setProperty("webdriver.gecko.driver","C:\\Marionette\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @When("I fill the registration form")
    @Pending
    public void whenIFillTheRegistrationForm() {
        // PENDING
    }

    @When("I submit the registration form")
    @Pending
    public void whenISubmitTheRegistrationForm() {
        // PENDING
    }

    @Then("A Thanks message is displayed")
    @Pending
    public void thenAThanksMessageIsDisplayed() {
        // PENDING
    }

}
