package pages;

import base.BasePage;
import utils.PlaywrightDriver;

public class CartPage extends BasePage {

    public void clickCheckoutButton() {

        click("checkout_button");

    }

    public void clickRemoveButton() {

        click("remove_button");

    }

    public String getRemovedCartItemAttributeValue() {

        return getAttributeValue("cart_contents", "class");

    }

}
