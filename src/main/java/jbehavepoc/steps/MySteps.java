package jbehavepoc.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MySteps {
    private String msg_actual = "Hello World";

    @Given("I have a story")
    public void iHaveAStory() {
        System.out.println("This is a story");
    }

    @When("I run the test")
    public void iRunTheTest() {
        System.out.println("Test is running");
    }

    @Then("A $msg_expected message appears")
    public void msgAppears(String msg_expected) {
        assertThat(msg_expected, equalTo(msg_actual));
    }
}

