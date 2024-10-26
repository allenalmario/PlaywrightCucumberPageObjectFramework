package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.PlaywrightFactory;

@Slf4j
public class LoginPageStepDefinitions {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("user navigates to login screen")
    public void user_navigates_to_login_screen() {
        loginPage.navigateToLoginPage();
    }

    @When("user enters {string} as username")
    public void userEntersAsUsername(String username) {
        loginPage.fillUsernameField(username);
    }

    @And("user enters {string} as password")
    public void userEntersAsPassword(String password) {
        loginPage.fillInPasswordField(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("user should be on the home page")
    public void user_should_be_on_the_home_page() {
        Assert.assertTrue(productsPage.assertOnProductsPage());
    }

    @Then("user should see an error message on the login screen")
    public void user_should_see_an_error_message_on_the_login_screen() {
        Assert.assertTrue(loginPage.assertLoginError());
    }

    @When("user clicks on hamburger menu")
    public void user_clicks_on_hamburger_menu() {
        productsPage.clickOnHamburgerMenu();
    }

    @When("user clicks on logout link")
    public void user_clicks_on_logout_link() {
        productsPage.clickLogoutLink();
    }

    @Then("user should be on the login page")
    public void user_should_be_on_the_login_page() {
        Assert.assertEquals(loginPage.assertOnLoginPage(), PlaywrightFactory.config.getProperty("baseurl"));
    }
}