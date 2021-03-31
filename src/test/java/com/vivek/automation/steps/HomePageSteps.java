package com.vivek.automation.steps;

import com.vivek.automation.TestState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.yecht.Data;

import static java.lang.String.format;

public class HomePageSteps extends TestState {

    public HomePageSteps() {
        super();
    }

    @Given("I am on the landing page")
    public void iAmOnLandingPage() {
        System.out.println("I am on the landing page");
        Assert.assertTrue(HomePage().isLoaded());
    }

    @When("I click on {string}")
    public void iClickOnLink(String link) {
        System.out.println("I click on "+ link);
        switch (link.toUpperCase()){
            case "CONTACT US":
                HomePage().ContactUs().click();
                break;
            case "SIGN IN":
                HomePage().SignIn().click();
                break;
            default:
                throw new AssertionError("Invalid link");
        }

    }

    @Then("I should navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        System.out.printf("I should navigate to %s page%n", pageName);
        switch (pageName.toUpperCase()){
            case "CONTACT US":
                Assert.assertEquals("Contact us - My Store", HomePage().ContactUsPage().getTitle());
                break;
            case "SIGN IN":
                Assert.assertEquals("Login - My Store", HomePage().SignInPage().getTitle());
                break;
            default:
                throw new AssertionError("Invalid pagename");
        }
    }
}
