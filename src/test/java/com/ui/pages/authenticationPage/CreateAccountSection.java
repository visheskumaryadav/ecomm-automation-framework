package com.ui.pages.authenticationPage;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountSection extends BrowserUtility {
    private static final By EMAIL_ADDRESS_LOCATOR=By.cssSelector("#email_create");
    private static final By CREATE_AN_ACCOUNT_BTN_LOCATOR=By.cssSelector("#SubmitCreate");
    public CreateAccountSection(WebDriver driver){
        super(driver);
    }

    public PersonalInformation createAccountWithEmail(String email){
        enterInTextBox(EMAIL_ADDRESS_LOCATOR,email);
        click(CREATE_AN_ACCOUNT_BTN_LOCATOR);
        return new PersonalInformation(getDriver());
    }


}
