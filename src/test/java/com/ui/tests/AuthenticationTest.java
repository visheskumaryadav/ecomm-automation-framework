package com.ui.tests;

import com.constants.Gender;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class AuthenticationTest extends TestBase{

    @Test(description = "Verify that user is able to login with valid credentials")
    public void loginWithValidCredentialsTest(){
        getSoftAssertion().assertEquals(
                homePage.goToSignInPage()
                        .loginWithValidCredentials("vishes@yopmail.com","password")
                        .getTopNotificationBar()
                        .getUserName(),
                "Vishes Yadav");

        getSoftAssertion().assertAll();
    }

    @Test(description = "Verify that user is able to login with invalid credentials")
    public void loginWithInValidCredentials(){
        getSoftAssertion().assertTrue(
                homePage.goToSignInPage()
                        .loginWithInvalidCredentials("vis34hes@yopmail.com","p33assword")
                        .getLoginErrorMsg().contains("Authentication failed.")
        );

        getSoftAssertion().assertAll();
    }

    @Test(description = "Verify that user is able to create an account")
    public void createAnAccount(){
        getSoftAssertion().assertTrue(
                homePage.goToCreateAccountPage()
                        .createAccountWithEmail("r44@yopmail.com")
                        .addPersonalInfo(Gender.MALE,"rahwul","kumar","4443332233")
                        .getSuccessMsg().contains("Your account has been created")
        );
        getSoftAssertion().assertAll();
    }
}
