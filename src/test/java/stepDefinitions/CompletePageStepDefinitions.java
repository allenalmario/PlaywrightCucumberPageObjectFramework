package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CompletePage;

public class CompletePageStepDefinitions {

    CompletePage completePage = new CompletePage();

    @Then("user should see a {string} message")
    public void user_should_see_a_message(String thankYouMessage) {
        Assert.assertEquals(completePage.extractOrderConfirmationText(), thankYouMessage);
    }

}