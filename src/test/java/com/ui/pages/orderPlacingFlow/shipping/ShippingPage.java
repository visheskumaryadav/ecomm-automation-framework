package com.ui.pages.orderPlacingFlow.shipping;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage extends BrowserUtility {
    private static final By CARRIER_RADIO_BTN = By.id("delivery_option_0");
    private static final By TERMS_CHECKBOX = By.id("cgv");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.name("processCarrier");
    private static final By CONTINUE_SHOPPING_LINK = By.cssSelector("a.button-exclusive");
    private static final By TERMS_ERROR_BOX=By.cssSelector(".fancybox-error");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void selectDefaultCarrier() {
        WebElement carrier =getElement(CARRIER_RADIO_BTN);
        if (!carrier.isSelected()) {
            click(carrier);
        }
    }

    public void acceptTermsOfService() {
        WebElement checkbox = getElement(TERMS_CHECKBOX);
        if (!checkbox.isSelected()) {
            click(checkbox);
        }
    }

    public void proceedToCheckout() {
       click(PROCEED_TO_CHECKOUT_BTN);
    }

    public void clickContinueShopping() {
        click(CONTINUE_SHOPPING_LINK);
    }

    public boolean isTermsCheckboxVisible() {
        return isElementDisplayed(TERMS_CHECKBOX);
    }
    public String getTermsErrorMsg(){
        return getElement(TERMS_ERROR_BOX).getText();
    }
}
