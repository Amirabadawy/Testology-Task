package pages;

import driver.WebDriverHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    public Wait<WebDriver> wait;

    public WebElement findElement(By locator) {
        wait = new WebDriverWait(WebDriverHandler.getWebDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return WebDriverHandler.getWebDriver().findElement(locator);
    }

    public void windowHandle(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String actual : windows) {
            if (!actual.equalsIgnoreCase(originalWindow)) {
                driver.switchTo().window(actual);
            }
        }
    }

    public void newWindowHandle(WebDriver driver) {
        String originalTab = driver.getWindowHandle();
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(originalTab))
                .findFirst()
                .get();
        driver.switchTo().window(newTab);
    }

}
