package pages;

import base.BasePage;

public class CheckoutCompletePage extends BasePage {

    public Boolean seeThankYouText() {

        return isElementPresent("thank_you_text");

    }

}
