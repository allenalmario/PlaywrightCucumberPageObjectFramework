package pages;

import base.BasePage;

public class HomePage extends BasePage {

    public boolean assertOnHomePage() {

        return(isElementPresent("products_title"));

    }

    public void clickOnHamburgerMenu() {

        click("hamburger_menu");

    }

    public void clickOnLogoutLink() {

        click("logout_link");

    }

    public void clickOnBackpackLink() {

        click("backpack_link");

    }

    public void clickOnOnesiesLink() {

        click("onesies_link");

    }

}
