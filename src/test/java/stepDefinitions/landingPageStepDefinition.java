package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class landingPageStepDefinition {
    TestContextSetup tcs;
    public landingPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("open OPEN CART site")
    public void open_open_cart_site() throws InterruptedException {
        tcs.POM.getLandingPage().addToCartIphone();


    }
    @When("cliked on iphone button")
    public void cliked_on_iphone_button() {


    }
    @Then("add iphone in add to cart")
    public void add_iphone_in_add_to_cart() {


    }



}
