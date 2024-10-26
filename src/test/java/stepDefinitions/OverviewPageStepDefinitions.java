package stepDefinitions;

import io.cucumber.java.en.And;
import pages.OverviewPage;

public class OverviewPageStepDefinitions {

    OverviewPage overviewPage = new OverviewPage();

    @And("user clicks on Finish button")
    public void user_clicks_on_finish_button() {
        overviewPage.clickFinishButton();
    }

}