package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.PlaywrightDriver;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user navigates to login screen")
    public void user_navigates_to_login_screen() {
        loginPage.navigateToLoginPage();
    }
    @When("user enters valid username")
    public void user_enters_valid_username() {
        loginPage.fillUsernameField(PlaywrightDriver.config.getProperty("username"));

    }
    @And("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.fillInPasswordField(PlaywrightDriver.config.getProperty("password"));
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }
    @Then("user should be on the home page")
    public void user_should_be_on_the_home_page() {
        Assert.assertTrue(homePage.assertOnHomePage());
    }

    @When("user enters a invalid username as {string}")
    public void userEntersAInvalidUsernameAs(String invalid_username) {
        loginPage.fillUsernameField(invalid_username);
    }


    @And("user enters a invalid password as {string}")
    public void userEntersAInvalidPasswordAs(String invalid_password) {
        loginPage.fillInPasswordField(invalid_password);
    }

    @Then("user should should see an error message on the login screen")
    public void userShouldShouldSeeAnErrorMessageOnTheLoginScreen() {
        Assert.assertTrue(loginPage.assertErrorMessageOnLoginPage());
    }

    @And("user clicks on hamburger menu")
    public void userClicksOnHamburgerMenu() {
        homePage.clickOnHamburgerMenu();
    }

    @And("user clicks on logout link")
    public void userClicksOnLogoutLink() {
        homePage.clickOnLogoutLink();
    }

    @Then("user should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        Assert.assertEquals(loginPage.assertOnLoginPage(), PlaywrightDriver.config.getProperty("baseurl"));
    }
}
