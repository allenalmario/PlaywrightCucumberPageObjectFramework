package pages;

import base.BasePage;
import utils.PlaywrightDriver;

public class CheckoutInformationPage extends BasePage {

    public void fillCheckoutFirstNameField() {

        type("checkout_first_name_field", PlaywrightDriver.config.getProperty("first_name"));

    }

    public void fillCheckoutLastNameField() {

        type("checkout_last_name_field", PlaywrightDriver.config.getProperty("last_name"));

    }

    public void fillCheckoutZipCodeField() {

        type("checkout_zip_code_field", PlaywrightDriver.config.getProperty("zip_code"));

    }

    public void clickOnCheckoutContinueButton() {

        click("checkout_continue_button");

    }

}
