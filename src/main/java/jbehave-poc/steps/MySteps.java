package jbehave;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class MySteps {
    @Given("I have a story")
    public void iHaveAStory (){
        System.out.println("This is a story");
    }

    @When("I run the test")
    public void iRunTheTest (){
        System.out.println("Test is running");
    }
    @Then("A hello world message appears")
    public void msgAppears (){
        System.out.println("Hello world");
    }
}
