package pages;

import base.BasePage;
import lombok.extern.java.Log;

@Log
public class ProductsPage extends BasePage {

    public boolean assertOnProductsPage() {
        log.info("Asserting page is on Products Page");
        return isElementPresent("products_page_title");
    }

    public void clickOnProductLink(String item) {
        log.info("Clicking on Product link for: " + item);
        switch (item) {
            case "Sauce Labs Backpack":
                click("sauce_labs_backpack_link");
                break;
            case "Sauce Labs Bolt T-Shirt":
                click("sauce_labs_bolt_tshirt_link");
                break;
            case "Sauce Labs Bike Light":
                click("sauce_labs_bike_light_link");
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                click("sauce_labs_tshirt_red_link");
                break;
        }
    }

    public void clickOnAddToCartButton(String item) {
        log.info("Clicking on Add to Cart button for item: " + item);
        switch (item) {
            case "Sauce Labs Onesie":
                click("sauce_labs_onesie_add_to_cart_button");
                break;
            case "Sauce Labs Fleece Jacket":
                click("sauce_labs_fleece_jacket_add_to_cart_button");
                break;
        }
    }

    public void clickOnRemoveButton(String item) {
        log.info("Clicking on Remove button for item: " + item);
        switch (item) {
            case "Sauce Labs Onesie":
                click("sauce_labs_onesie_remove_button");
                break;
            case "Sauce Labs Fleece Jacket":
                click("sauce_labs_fleece_jacket_remove_button");
                break;
            case "Sauce Labs Bike Light":
                click("product_page_remove_button");
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                click("sauce_labs_tshirt_red_remove_button");
                break;
        }
    }

    public boolean addToCartElementIsVisible(String item) {
        log.info("Checking if Add to Cart element is visible for: " + item);
        switch (item) {
            case "Sauce Labs Onesie":
                return isElementPresent("sauce_labs_onesie_add_to_cart_button");
            case "Sauce Labs Bike Light":
                return isElementPresent("product_page_add_to_cart_button");
            default:
                return false;
        }
    }

}