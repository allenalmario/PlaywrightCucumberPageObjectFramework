package pages;

import base.BasePage;
import lombok.extern.java.Log;

@Log
public class ProductPage extends BasePage {

    public void clickOnAddToCartButton() {
        log.info("Clicking on Add to Cart button");
        click("product_page_add_to_cart_button");
    }

    public void clickOnBackToProductsLink() {
        log.info("Clicking on Back to Products link");
        click("back_to_products_link");
    }

}
