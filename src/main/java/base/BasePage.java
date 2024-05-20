package base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;
import utils.PlaywrightDriver;

public class BasePage {

    public static Page page;

    public BasePage() {

        page = PlaywrightDriver.getPage();

    }

    public void click(String locatorKey) {

        try {
            page.locator(PlaywrightDriver.objectRepository.getProperty(locatorKey)).click();
        } catch (Throwable t) {

            Assert.fail(t.getMessage());
        }
    }


    public void mouseHover(String locatorKey) {

        try {
            page.hover(PlaywrightDriver.objectRepository.getProperty(locatorKey));
        } catch (Throwable t) {

            Assert.fail(t.getMessage());
        }
    }

    public boolean isElementPresent(String locatorKey) {

        try {
            page.waitForSelector(PlaywrightDriver.objectRepository.getProperty(locatorKey), new Page.WaitForSelectorOptions().setTimeout(2000));

            return true;
        } catch (Throwable t) {


            return false;
        }

    }

    public void type(String locatorKey, String value) {
        try {
            page.locator(PlaywrightDriver.objectRepository.getProperty(locatorKey)).fill(value);
        } catch (Throwable t) {

            Assert.fail(t.getMessage());
        }
    }


    public void select(String locatorKey, String value) {
        try {
            page.selectOption(PlaywrightDriver.objectRepository.getProperty(locatorKey),new SelectOption().setLabel(value));
        } catch (Throwable t) {

            Assert.fail(t.getMessage());
        }
    }

    public String returnPageUrl() {
        return page.url();
    }

    public void clickCartButton() {

        click("cart_button");

    }

    public String getAttributeValue(String locatorKey, String attributeName) {

        return page.locator(PlaywrightDriver.objectRepository.getProperty(locatorKey)).getAttribute(attributeName);

    }

}