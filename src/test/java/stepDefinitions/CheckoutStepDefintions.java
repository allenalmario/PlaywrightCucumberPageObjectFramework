package stepDefinitions;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.*;

public class CheckoutStepDefintions {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    ItemPage itemPage = new ItemPage();
    CartPage cartPage = new CartPage();
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @And("user clicks on the backpack item")
    public void user_clicks_on_the_backpack_item() {
        homePage.clickOnBackpackLink();
    }
    @And("user clicks on the add to cart button")
    public void userClicksOnTheAddToCartButton() {
        itemPage.clickAddToCartButton();
    }
    @And("user clicks on the cart button")
    public void user_clicks_on_the_cart_button() {
        basePage.clickCartButton();
    }
    @And("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }

    @And("user fills first name in checkout process")
    public void userFillsFirstNameInCheckoutProcess() {
        checkoutInformationPage.fillCheckoutFirstNameField();
    }

    @And("user fills last name in checkout process")
    public void userFillsLastNameInCheckoutProcess() {
        checkoutInformationPage.fillCheckoutLastNameField();
    }

    @And("user fills zip code in checkout process")
    public void userFillsZipCodeInCheckoutProcess() {
        checkoutInformationPage.fillCheckoutZipCodeField();
    }

    @And("user clicks on checkout continue button")
    public void userClicksOnCheckoutContinueButton() {
        checkoutInformationPage.clickOnCheckoutContinueButton();
    }

    @And("user clicks on finish button")
    public void userClicksOnFinishButton() {

        checkoutOverviewPage.clickOnCheckoutFinishButton();

    }

    @Then("user should be on the checkout complete page")
    public void userShouldBeOnTheCheckoutCompletePage() {

        Assert.assertTrue(checkoutCompletePage.seeThankYouText());

    }

    @And("user clicks on the remove button")
    public void userClicksOnTheRemoveButton() {

        cartPage.clickRemoveButton();

    }

    @Then("the item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {

        String hello = cartPage.getRemovedCartItemAttributeValue();
        System.out.println(hello);

        Assert.assertEquals(cartPage.getRemovedCartItemAttributeValue(), "removed_cart_item");

    }

    @And("user clicks on the sauce labs onesie item")
    public void userClicksOnTheSauceLabsOnesieItem() {

        homePage.clickOnOnesiesLink();

    }
}
