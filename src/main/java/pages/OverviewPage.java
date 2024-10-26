package pages;

import base.BasePage;
import lombok.extern.java.Log;

@Log
public class OverviewPage extends BasePage {

    public void clickFinishButton() {
        log.info("Clicking on Finish button");
        click("finish_button");
    }

}
