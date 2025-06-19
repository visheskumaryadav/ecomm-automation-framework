package com.ui.pages.orderPlacingFlow.cartSummary;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItems extends BrowserUtility {
    private WebElement itemRoot;
    private static final By PRODUCT_NAME = By.cssSelector(".cart_description .product-name");
    private static final By UNIT_PRICE = By.cssSelector(".cart_unit .price");
    private static final By TOTAL_PRICE = By.cssSelector(".cart_total .price");
    private static final By STOCK_LABEL = By.cssSelector(".cart_avail .label");
    private static final By DISCOUNT_LABEL = By.cssSelector(".price-percent-reduction");

    public CartItems(WebDriver driver, WebElement item) {
        super(driver);
        this.itemRoot=item;
    }
    public int getTotalItemPrice(){
        return Integer.parseInt(getElement(TOTAL_PRICE).getText());
    }

    public String getStockLabel(){
        return getElement(STOCK_LABEL).getText();
    }
    public String getProductName(){
        return getElement(PRODUCT_NAME).getText();
    }


}
