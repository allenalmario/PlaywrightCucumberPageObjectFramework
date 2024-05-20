package pages;

import base.BasePage;
import utils.PlaywrightDriver;


public class LoginPage extends BasePage {

    public void navigateToLoginPage() {

        PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("baseurl"));

    }

    public void fillUsernameField(String username) {

        type("username_field", username);

    }


    public void fillInPasswordField(String password) {

        type("password_field", password);

    }

    public void clickOnLoginButton() {

        click("login_button");

    }

    public Boolean assertErrorMessageOnLoginPage() {

        return isElementPresent("login_error_message");

    }

    public String assertOnLoginPage() {

        return returnPageUrl();

    }

}