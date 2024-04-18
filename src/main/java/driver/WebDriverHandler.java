package driver;

import helper.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WebDriverHandler {
    private static WebDriver webDriver;

    public WebDriverHandler() throws IOException {
        getDriverType();
    }

    private void getDriverType() throws IOException {
        String browserName = getBrowserName();

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeCapabilities = new ChromeOptions();
                webDriver = new ChromeDriver(chromeCapabilities);
                break;

            case "safari":
                SafariOptions options = new SafariOptions();
                webDriver = new SafariDriver(options);
                break;
        }

    }

    public static String getBrowserName() throws IOException {
        return ReadProperties.setConfig().getProperty("browserName");
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public void close() {
        webDriver.quit();
    }

}
