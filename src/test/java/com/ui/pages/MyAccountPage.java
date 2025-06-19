package com.ui.pages;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    private static final By SUCCESS_ALERT_LOCATOR = By.cssSelector(".alert.alert-success");
    private static final By ADD_FIRST_ADDRESS_BTN = By.cssSelector("a[title='Add my first address']");
    private static final By ORDER_HISTORY_BTN = By.cssSelector("a[title='Orders']");
    private static final By CREDIT_SLIPS_BTN = By.cssSelector("a[title='Credit slips']");
    private static final By MY_ADDRESSES_BTN = By.cssSelector("a[title='Addresses']");
    private static final By PERSONAL_INFO_BTN = By.cssSelector("a[title='Information']");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedSuccessMessageDisplayed() {
        return isElementVisible(SUCCESS_ALERT_LOCATOR);
    }

    public void clickAddMyFirstAddress() {
        click(ADD_FIRST_ADDRESS_BTN);
    }

    public void clickOrderHistoryAndDetails() {
        click(ORDER_HISTORY_BTN);
    }

    public void clickMyCreditSlips() {
        click(CREDIT_SLIPS_BTN);
    }

    public void clickMyAddresses() {
        click(MY_ADDRESSES_BTN);


    }
    public void clickMyPersonalInformation() {
            click(PERSONAL_INFO_BTN);
    }


}

