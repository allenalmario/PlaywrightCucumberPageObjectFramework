package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.InformationPage;

public class InformationPageStepDefinitions {

    InformationPage informationPage = new InformationPage();

    @And("user fills out First Name field")
    public void user_fills_out_first_name_field() {
        informationPage.fillFirstNameField();
    }

    @And("user fills out Last Name field")
    public void user_fills_out_last_name_field() {
        informationPage.fillLastNameField();
    }

    @And("user fills out Zip Code field")
    public void user_fills_out_zip_code_field() {
        informationPage.fillZipCodeField();
    }

    @And("user clicks Continue button")
    public void user_clicks_on_continue_button() {
        informationPage.clickOnContinueButton();
    }

    @Then("user should see {string} error message")
    public void userShouldSeeErrorMessage(String errorMessage) {
        if (errorMessage.contains("First Name")) {
            Assert.assertEquals(informationPage.extractErrorMessage("First Name"), errorMessage);
        } else if (errorMessage.contains("Last Name")) {
            Assert.assertEquals(informationPage.extractErrorMessage("Last Name"), errorMessage);

        } else if (errorMessage.contains("Postal Code")) {
            Assert.assertEquals(informationPage.extractErrorMessage("Postal Code"), errorMessage);

        }
    }

}