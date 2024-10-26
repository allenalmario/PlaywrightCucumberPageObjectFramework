package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import lombok.extern.java.Log;
import utils.PlaywrightFactory;

import java.nio.file.Paths;

@Log
public class Hooks {

    Page page;

    @Before
    public void setUp(Scenario scenario) {
        log.info("~~~Before~~~Before~~~Before~~~");
        log.info("Starting Test: " + scenario.getName());

        PlaywrightFactory.setupDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("~~~After~~~After~~~After~~~");
        log.info("Test Result: " + scenario.getStatus());

        if (scenario.isFailed()) {
            page = PlaywrightFactory.getPage();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/screenshot/screenshot.png")));
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        PlaywrightFactory.closeBrowser();
        PlaywrightFactory.quitPlaywright();
    }
}