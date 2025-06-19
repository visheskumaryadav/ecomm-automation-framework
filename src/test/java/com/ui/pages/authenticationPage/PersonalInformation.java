package com.ui.pages.authenticationPage;

import com.constants.Gender;
import com.ui.pages.MyAccountPage;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformation extends BrowserUtility {
    private static final By MR_RADIO_BTN_LOCATOR=By.cssSelector("#uniform-id_gender1");
    private static final By MRS_RADIO_BTN_LOCATOR=By.cssSelector("#uniform-id_gender2");
    private static final By LASTNAME_TEXT_INPUT_FIELD_LOCATOR=By.cssSelector("#customer_lastname");
    private static final By FIRSTNAME_TEXT_INPUT_FIELD_LOCATOR=By.cssSelector("#customer_firstname");
    private static final By EMAIL_FIELD_LOCATOR=By.cssSelector("#email");
    private static final By PASSWORD_FIELD_LOCATOR=By.cssSelector("#passwd");
    private static final By REGISTER_BTN=By.cssSelector("#submitAccount");

    public PersonalInformation(WebDriver driver){
        super(driver);
    }

    public MyAccountPage addPersonalInfo(Gender gender, String firstName, String lastName, String password){
        if(gender==Gender.MALE){
            selectRadioBtn(MR_RADIO_BTN_LOCATOR);
        }else{
            selectRadioBtn(MRS_RADIO_BTN_LOCATOR);

        }
        enterInTextBox(FIRSTNAME_TEXT_INPUT_FIELD_LOCATOR,firstName);
        enterInTextBox(LASTNAME_TEXT_INPUT_FIELD_LOCATOR,lastName);
        enterInTextBox(PASSWORD_FIELD_LOCATOR,password);
        click(REGISTER_BTN);
        return new MyAccountPage(getDriver());
    }




}
