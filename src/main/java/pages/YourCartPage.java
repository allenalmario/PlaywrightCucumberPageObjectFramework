package pages;

import base.BasePage;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class YourCartPage extends BasePage {

    public boolean isItemPresentInCart(String itemName) {
        System.out.println("Checking if " + itemName + " is in cart");

        // Locate the cart list
        List<ElementHandle> listItems = page.querySelectorAll("div.cart_list > div.cart_item");
        for (ElementHandle listItem : listItems) {
            // Locate the nested div under cart_item > cart_item_label > a
            String quantityText = listItem.querySelector("div.cart_quantity").innerText();

            if (!quantityText.equals("1")) {
                throw new AssertionError("Quantity is not correct."); // Stop execution and signal an error
            }

            String labelText = listItem.querySelector("div.cart_item_label > a > div").innerText();

            // Check if the label matches the item name
            if (labelText.equals(itemName)) {
                System.out.println("Item found in cart: " + labelText);
                return true;
            }
        }
        return false;
    }

    public void clickOnCheckOutButton() {
        log.info("Clicking on Checkout button");
        click("checkout_button");
    }

}