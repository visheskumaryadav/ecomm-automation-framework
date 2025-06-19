package com.ui.pages.authenticationPage;

import org.openqa.selenium.WebDriver;

public class AuthenticationPage  {
    private final LoginSection loginSection;
    private final CreateAccountSection createAccountSection;
    public AuthenticationPage(WebDriver driver){
        loginSection =new LoginSection(driver);
        createAccountSection =new CreateAccountSection(driver);
    }

    public LoginSection getLoginSection() {
        return loginSection;
    }

    public CreateAccountSection getCreateAccountSection() {
        return createAccountSection;
    }


}
