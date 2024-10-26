package base;

import com.microsoft.playwright.Page;
import lombok.extern.java.Log;
import org.testng.Assert;
import utils.PlaywrightFactory;

@Log
public class BasePage {

    public static Page page;

    public BasePage() {
        page = PlaywrightFactory.getPage();
    }

    public void click(String locatorKey) {
        try {
            page.locator(PlaywrightFactory.objectRepository.getProperty(locatorKey)).click();
        } catch (Throwable t) {
            Assert.fail(t.getMessage());
        }
    }

    public boolean isElementPresent(String locatorKey) {
        try {
            page.waitForSelector(PlaywrightFactory.objectRepository.getProperty(locatorKey), new Page.WaitForSelectorOptions().setTimeout(2000));
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public void type(String locatorKey, String value) {
        try {
            page.locator(PlaywrightFactory.objectRepository.getProperty(locatorKey)).fill(value);
        } catch (Throwable t) {
            Assert.fail(t.getMessage());
        }
    }

    public String returnPageUrl() {
        return page.url();
    }

    public void clickOnHamburgerMenu() {
        log.info("Clicking on Hamburger Menu");
        click("hamburger_menu");
    }

    public void clickLogoutLink() {
        log.info("Clicking on Logout link");
        click("logout_link");
    }

    public void clickOnCartLink() {
        log.info("Clicking on Cart button");
        click("cart_button");
    }

    public String getElementText(String locatorKey) {
        log.info("Extracting text from element");
        String textExtracted = page.locator(PlaywrightFactory.objectRepository.getProperty(locatorKey)).textContent();
        log.info("Text Extracted: " + textExtracted);
        return textExtracted;
    }

}