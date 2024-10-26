package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProductsPage;

public class ProductsPageStepDefinitions {

    ProductsPage productsPage = new ProductsPage();

    @And("user clicks on {string} item")
    public void userClicksOnItem(String item) {
        productsPage.clickOnProductLink(item);
    }

    @And("user clicks on {string} Add to cart button")
    public void userClicksOnAddToCartButton(String item) {
        
    }

    @And("user clicks on {string} Remove button")
    public void userClicksOnRemoveButton(String item) {
        
    }

    @Then("the {string} Add to Cart button should be visible")
    public void theAddToCartButtonShouldBeVisible(String item) {
    }
}
