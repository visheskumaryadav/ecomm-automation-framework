package com.ui.pages.productDetailsPage;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPopup extends BrowserUtility {

    // Locators
    private static final By POPUP = By.id("layer_cart"); // full modal container
    private static final By SUCCESS_MESSAGE = By.cssSelector(".layer_cart_product h2");
    private static final By PRODUCT_NAME = By.id("layer_cart_product_title");
    private static final By PRODUCT_ATTRIBUTES = By.id("layer_cart_product_attributes");
    private static final By PRODUCT_QUANTITY = By.id("layer_cart_product_quantity");
    private static final By PRODUCT_TOTAL = By.id("layer_cart_product_price");

    private static final By TOTAL_PRODUCTS = By.cssSelector(".layer_cart_row span.ajax_block_products_total");
    private static final By TOTAL_SHIPPING = By.cssSelector(".layer_cart_row span.ajax_cart_shipping_cost");
    private static final By TOTAL_PRICE = By.cssSelector(".layer_cart_row span.ajax_block_cart_total");

    private static final By CONTINUE_SHOPPING_BTN = By.cssSelector("span.continue > span");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("a.btn.btn-default.button.button-medium");
    private static final By CLOSE_ICON = By.cssSelector("span.cross");

    public AddToCartPopup(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        return isElementVisible(POPUP);
    }

    public String getSuccessMessage() {
        return getElement(SUCCESS_MESSAGE).getText();
    }

    public String getProductName() {
        return getElement(PRODUCT_NAME).getText();
    }

    public String getProductAttributes() {
        return getElement(PRODUCT_ATTRIBUTES).getText();
    }

    public String getProductQuantity() {
        return getElement(PRODUCT_QUANTITY).getText();
    }

    public String getProductTotalPrice() {
        return getElement(PRODUCT_TOTAL).getText();
    }

    public String getTotalCartValue() {
        return getElement(TOTAL_PRICE).getText();
    }

    public void clickProceedToCheckout() {
        click(PROCEED_TO_CHECKOUT_BTN);
        return;
    }

    public void clickContinueShopping() {
        click(CONTINUE_SHOPPING_BTN);
    }

    public void closePopup() {
        click(CLOSE_ICON);
    }
}
