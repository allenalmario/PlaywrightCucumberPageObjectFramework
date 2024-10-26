package pages;

import base.BasePage;
import lombok.extern.java.Log;

@Log
public class CompletePage extends BasePage {

    public String extractOrderConfirmationText() {
        log.info("Extracting Thank you message");
        return getElementText("orderConfirmationText");
    }

}
