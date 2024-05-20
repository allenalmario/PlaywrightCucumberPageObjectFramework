package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import lombok.extern.java.Log;
import utils.PlaywrightDriver;

import java.nio.file.Paths;

@Log
public class Hooks {

    Page page;

    @BeforeAll
    public static void beforeAll() {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Playwright with Java Cucumber BDD Test Automation Framework");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Before
    public void setUp(Scenario scenario) {

        log.info("~~~Before~~~Before~~~Before~~~");
        log.info("Starting Test: " + scenario.getName());

        PlaywrightDriver.setupDriver();

    }

    @After
    public void tearDown(Scenario scenario) {

        log.info("~~~After~~~After~~~After~~~");
        log.info("Test Result: " + scenario.getStatus());

        if (scenario.isFailed()) {
            page = PlaywrightDriver.getPage();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/screenshot/screenshot.png")));
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        PlaywrightDriver.closeBrowser();
        PlaywrightDriver.quitPlaywright();

    }

    @AfterAll
    public static void afterAll() {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("ALL TEST EXECUTION COMPLETED");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

}