package base;

import browser.Browser;
import driver.WebDriverHandler;
import helper.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    protected static Browser browser;
    protected WebDriverHandler webDriverHandler;

    @BeforeMethod
    public void setUp() throws IOException {
        webDriverHandler = new WebDriverHandler();
        browser = new Browser();
        webDriverHandler.navigateTo(ReadProperties.setConfig().getProperty("url"));
        webDriverHandler.maximizeWindow();
    }

    @AfterMethod()
    public void tearDown() {
        webDriverHandler.close();
    }

}
