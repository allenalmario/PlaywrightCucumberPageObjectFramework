package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Log
public class PlaywrightFactory {

    public static PlaywrightFactory playwrightFactory;
    private static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static Properties objectRepository = new Properties();
    public static Properties config = new Properties();
    private static FileInputStream inputStream;

    private PlaywrightFactory() {

        try {
            inputStream = new FileInputStream("./src/main/resources/properties/objectRepository.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            objectRepository.load(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            inputStream = new FileInputStream("./src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            config.load(inputStream);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        playwright = Playwright.create();

        Boolean headlessValue = Boolean.parseBoolean(config.getProperty("headless"));

        switch (config.getProperty("browser")) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessValue));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headlessValue));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headlessValue));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headlessValue));
                break;
        }
        page = browser.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void setupDriver() {
        playwrightFactory = new PlaywrightFactory();
    }

    public static void openPage(String url) {
        log.info("Navigating to: " + url);
        page.navigate(url);
    }

    public static void closeBrowser() {
        browser.close();
        page.close();
    }

    public static void quitPlaywright() {
        if(page!=null) {
            playwright.close();
        }
    }

}