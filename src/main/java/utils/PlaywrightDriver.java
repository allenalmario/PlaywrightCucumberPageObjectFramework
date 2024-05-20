package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightDriver {

    public static PlaywrightDriver playwrightDriver;
    private static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static Properties objectRepository = new Properties();
    public static Properties config = new Properties();
    private static FileInputStream inputStream;

    private PlaywrightDriver() {

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

        switch (config.getProperty("browser")) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
        }

        page = browser.newPage();

    }

    public static Page getPage() {

        return page;

    }

    public static void setupDriver() {

        playwrightDriver = new PlaywrightDriver();

    }

    public static void openPage(String url) {

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