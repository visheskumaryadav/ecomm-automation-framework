package com.ui.pages.orderPlacingFlow.OrderConfirmation;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BrowserUtility {
    private static final By SUCCESS_ALERT = By.cssSelector(".cheque-indent strong");
    private static final By CONFIRMATION_BOX = By.cssSelector(".box"); // check payment instructions
    private static final By ORDER_HISTORY_LINK = By.cssSelector("a[title='Back to orders']");

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return getElement(SUCCESS_ALERT).getText(); // "Your order on My Shop is complete."
    }

    public String getPaymentInstructions() {
        return getElement(CONFIRMATION_BOX).getText(); // Payment method instructions
    }

    public void goToOrderHistory() {
        click(ORDER_HISTORY_LINK);
    }
}
