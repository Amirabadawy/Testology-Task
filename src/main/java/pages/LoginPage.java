package pages;

import driver.WebDriverHandler;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private final By hyperLink = By.xpath("//a[@class='blinkingText']");
    private final By userNameInput = By.id("username");


    public void clickOnHyperLink(){
        findElement(hyperLink).click();
    }

    public void enterUseName(String userName){
        windowHandle(WebDriverHandler.getWebDriver());
        findElement(userNameInput).sendKeys(userName);
    }
}
