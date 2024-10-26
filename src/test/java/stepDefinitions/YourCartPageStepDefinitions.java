package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.YourCartPage;

public class YourCartPageStepDefinitions {

    YourCartPage yourCartPage = new YourCartPage();

    @And("user ensures the item {string} is in cart and quantity is correct")
    public void userEnsuresTheItemNameIs(String itemName) {
        Assert.assertTrue(yourCartPage.isItemPresentInCart(itemName));
    }

    @And("user clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        yourCartPage.clickOnCheckOutButton();
    }

    @Then("the {string} should not be in the cart")
    public void theShouldNotBeInTheCart(String item) {
        Assert.assertFalse(yourCartPage.isItemPresentInCart(item));
    }

}