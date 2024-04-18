package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithEmail(){
        browser.rahulshetty.login.clickOnHyperLink();
        String email = browser.rahulshetty.home.getEmailText();
        browser.rahulshetty.login.enterUseName(email);
    }
}
