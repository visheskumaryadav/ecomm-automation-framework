package com.ui.pages.orderPlacingFlow.payment;

import com.ui.pages.orderPlacingFlow.OrderConfirmation.OrderConfirmationPage;
import com.ui.utilities.BrowserUtility;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {
    @Getter
    private PaymentCartSummary paymentCartSummary;
    private ProductsOnPaymentPage productsOnPaymentPage;
    private boolean isPaymentMethodClicked;
    private static final By PAY_BY_BANK_WIRE_BTN = By.cssSelector("a.bankwire");
    private static final By PAY_BY_CHECK_BTN = By.cssSelector("a.cheque");
    private static final By CONTINUE_SHOPPING_LINK = By.cssSelector("a.button-exclusive");

    private static final By CONFIRM_MY_ORDER_BTN=By.cssSelector("#cart_navigation>button");
    private static final By OTHER_PAYMENT_METHOD_LINK=By.cssSelector("#cart_navigation>a");
    private static final By TOTAL_PRICE = By.id("total_price");


    public PaymentPage(WebDriver driver) {
        super(driver);
        paymentCartSummary = new PaymentCartSummary(getDriver());

    }

    public String getTotalAmount() {
        return getElement(TOTAL_PRICE).getText(); // e.g. "$36"
    }

    public void payByBankWire() {
      click(PAY_BY_BANK_WIRE_BTN);
      isPaymentMethodClicked=true;
    }

    public void payByCheck() {
       click(PAY_BY_CHECK_BTN);
    }

    public void clickContinueShopping() {
        click(CONTINUE_SHOPPING_LINK);
    }
    public OrderConfirmationPage clickToPlaceOrder(){
        if(isPaymentMethodClicked){
            click(CONFIRM_MY_ORDER_BTN);
            return new OrderConfirmationPage(getDriver());
        }else{
            System.err.println("I CONFIRM MY ORDER btn is not present");
        }

        return null;
    }
    public void clickToGoOtherPayments(){
        if(isPaymentMethodClicked){
            click(OTHER_PAYMENT_METHOD_LINK);
            isPaymentMethodClicked=false;
        }else{
            System.err.println("OTHER_PAYMENT_METHOD_LINK is not present");
        }

    }
}
