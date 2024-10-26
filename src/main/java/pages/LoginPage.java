package pages;

import base.BasePage;
import lombok.extern.java.Log;
import utils.PlaywrightFactory;

import static utils.PlaywrightFactory.openPage;

@Log
public class LoginPage extends BasePage {

    public void navigateToLoginPage() {
        log.info("Navigating to: " + PlaywrightFactory.config.getProperty("baseurl"));
        openPage(PlaywrightFactory.config.getProperty("baseurl"));
    }

    public void fillUsernameField(String username) {
        log.info("Filling Username field");
        type("username_field", username);
    }

    public void fillInPasswordField(String password) {
        log.info("Filling Password field");
        type("password_field", password);
    }

    public void clickOnLoginButton() {
        log.info("Clicking on Login button");
        click("login_button");
    }

    public boolean assertLoginError() {
        log.info("Asserting login error shows after logging in with invalid username and password on Login Page");
        return isElementPresent("login_error_message");
    }

    public String assertOnLoginPage() {
        log.info("Asserting on Login page");
        return returnPageUrl();
    }

}