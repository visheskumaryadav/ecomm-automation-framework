package com.ui.pages.authenticationPage;

import com.ui.pages.homepage.HomePage;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSection extends BrowserUtility {
    private static final By EMAIL_ADDRESS_LOCATOR=By.cssSelector("#email");
    private static final By PASSWORD_LOCATOR=By.cssSelector("#passwd");
    private static final By SIGN_IN_BTN_LOCATOR=By.cssSelector("#SubmitLogin");
    private static final By FORGOT_PASSWORD_LINK_LOCATOR=By.cssSelector(".lost_password.form-group");
    private static final By LOGIN_ERROR_MSG=By.cssSelector("div.alert.alert-danger>ol");

    public LoginSection(WebDriver driver){
        super(driver);
    }

    private void performLogin(String email, String pass){
        enterInTextBox(EMAIL_ADDRESS_LOCATOR,email);
        enterInTextBox(PASSWORD_LOCATOR,pass);
        click(SIGN_IN_BTN_LOCATOR);
    }

    public HomePage loginWithValidCredentials(String email, String pass){
        performLogin(email,pass);
        return new HomePage(getDriver());

    }
    public LoginSection loginWithInvalidCredentials(String email, String password) {
        performLogin(email, password);
        return this;
    }
    public String getLoginErrorMsg(){
        return getElement(LOGIN_ERROR_MSG).getText();
    }
}
