package com.ui.pages.orderPlacingFlow.cartSummary;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderTotal extends BrowserUtility {

    private static By TOTAL_PRODUCT_LOCATOR= By.cssSelector("#total_product");
    private static By TOTAL_SHIPPING_LOCATOR= By.cssSelector("#total_shipping");
    private static By TOTAL_PRICE_LOCATOR=By.cssSelector("#total_price");

    public OrderTotal(WebDriver driver)
    {
        super(driver);
    }

    public int getTotalProductPrice(){
        return Integer.parseInt(getElement(TOTAL_PRODUCT_LOCATOR).getText());
    }
    public int getTotalPrice(){
        return Integer.parseInt(getElement(TOTAL_PRICE_LOCATOR).getText());
    }
    public int getTotalShippingPrice(){
        return Integer.parseInt(getElement(TOTAL_SHIPPING_LOCATOR).getText());
    }
}
