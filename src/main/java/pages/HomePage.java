package pages;

import driver.WebDriverHandler;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private final By emailText = By.xpath("//li[normalize-space()='contact@rahulshettyacademy.com']");

    public String getEmailText() {
        newWindowHandle(WebDriverHandler.getWebDriver());
        System.out.println(WebDriverHandler.getWebDriver().getCurrentUrl());
        String emailTextValue = findElement(emailText).getText();
        return emailTextValue;
    }

}
