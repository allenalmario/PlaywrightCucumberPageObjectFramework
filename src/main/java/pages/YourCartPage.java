package pages;

import base.BasePage;
import lombok.extern.java.Log;

@Log
public class YourCartPage extends BasePage {

    public boolean isItemPresentInCart(String itemName) {
//        log.info("Checking if " + itemName + " is in cart");
//        WebElement list = driver.findElement(By.xpath("//div[@class='cart_list']"));
//        List<WebElement> listItems = list.findElements(By.className("cart_item"));
//        for (WebElement listItem : listItems) {
//            // Locate the nested div under cart_item > cart_item_label > a
//            WebElement quantityDiv = listItem.findElement(By.className("cart_quantity"));
//            String quantityText = quantityDiv.getText();
//            if (!quantityText.equals("1")) {
//                throw new AssertionError("Quantity is not correct."); // Stop execution and signal an error
//            }
//            WebElement labelDiv = listItem.findElement(By.xpath(".//div[@class='cart_item_label']/a/div"));
//
//            // Extract and print the information from the div
//            String labelText = labelDiv.getText(); // Get the text inside the div
//            if (labelText.equals(itemName)) {
//                return true;
//            }
//        }
            return false;
    }

    public void clickOnCheckOutButton() {
        log.info("Clicking on Checkout button");
        click("checkout_button");
    }

}