package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ProductsPage;

public class ProductsPageStepDefinitions {

    ProductsPage productsPage = new ProductsPage();

    @And("user clicks on {string} item")
    public void userClicksOnItem(String item) {
        productsPage.clickOnProductLink(item);
    }

    @And("user clicks on {string} Add to cart button")
    public void userClicksOnAddToCartButton(String item) {
        productsPage.clickOnAddToCartButton(item);
    }

    @And("user clicks on {string} Remove button")
    public void userClicksOnRemoveButton(String item) {
        productsPage.clickOnRemoveButton(item);
    }

    @Then("the {string} Add to Cart button should be visible")
    public void theAddToCartButtonShouldBeVisible(String item) {
        Assert.assertTrue(productsPage.addToCartElementIsVisible(item));
    }
}
