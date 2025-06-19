package com.ui.pages.orderPlacingFlow.cartSummary;

import com.ui.pages.authenticationPage.AuthenticationPage;
import com.ui.pages.orderPlacingFlow.cartSummary.CartItems;
import com.ui.pages.orderPlacingFlow.cartSummary.OrderTotal;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartSummaryPage extends BrowserUtility {

    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final By DELIVERY_ADDRESS_BOX = By.cssSelector("ul#address_delivery");
    private static final By INVOICE_ADDRESS_BOX = By.cssSelector("ul#address_invoice");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("a.button.btn.btn-default.standard-checkout");
    private static final By CONTINUE_SHOPPING_BTN=By.cssSelector("a.btn[title='Continue shopping']");
    public CartSummaryPage(WebDriver driver){
        super(driver);
    }

    public List<CartItems> getCartItems() {
        List<WebElement> items = getElements(CART_ITEM);
        List<CartItems> cartItems = new ArrayList<>();

        for (WebElement item : items) {
            cartItems.add(new CartItems(getDriver(), item));
        }
        return cartItems;
    }

    public OrderTotal getOrderTotalInfo() {
        return new OrderTotal(getDriver());
    }

    public AuthenticationPage clickToProceed() {
        click(PROCEED_TO_CHECKOUT_BTN);
        return new AuthenticationPage(getDriver());
    }

    public void clickToContinueShopping() {
        click(CONTINUE_SHOPPING_BTN);
    }
}
