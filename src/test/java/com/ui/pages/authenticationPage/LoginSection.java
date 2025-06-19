package com.ui.pages.authenticationPage;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSection extends BrowserUtility {
    private static final By EMAIL_ADDRESS_LOCATOR=By.cssSelector("#email");
    private static final By PASSWORD_LOCATOR=By.cssSelector("#passwd");
    private static final By SIGN_IN_BTN_LOCATOR=By.cssSelector("#SubmitLogin");
    private static final By FORGOT_PASSWORD_LINK_LOCATOR=By.cssSelector(".lost_password.form-group");

    public LoginSection(WebDriver driver){
        super(driver);
    }

    public void doSignInWith(String email,String pass){
        enterInTextBox(EMAIL_ADDRESS_LOCATOR,email);
        enterInTextBox(PASSWORD_LOCATOR,pass);
        click(SIGN_IN_BTN_LOCATOR);
    }
}
