package com.ui.pages.commonComponents;

import com.ui.pages.authenticationPage.AuthenticationPage;
import com.ui.pages.homepage.HomePage;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNotificationBar extends BrowserUtility {
    private static final By SIGN_IN_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
    private static final By CONTACT_US_LOCATOR= By.cssSelector("#contact-link");
    private static final By SIGN_OUT_LOCATOR = By.cssSelector(".logout");
    private static final By USER_NAME_LOCATOR = By.cssSelector(".header_user_info .account span");
    public TopNotificationBar(WebDriver driver){
        super(driver);
    }

    public AuthenticationPage goToSignInPage(){
        click(SIGN_IN_LOCATOR);
        return new AuthenticationPage(getDriver());
    }
    public HomePage clickOnSignOut(){
        click(SIGN_OUT_LOCATOR);
        return new HomePage(getDriver());
    }
    public void goToContactUsPage(){
        click(CONTACT_US_LOCATOR);
    }

    public String getUserName(){
       return getElement(USER_NAME_LOCATOR).getText().trim();

    }
}
