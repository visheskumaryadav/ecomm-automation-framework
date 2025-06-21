package com.ui.pages.orderPlacingFlow.payment;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PaymentCartSummary extends BrowserUtility {
    private static final By TOTAL_PRODUCTS_PRICE=By.id("total_product");
    private static final By TOTAL_SHIPPING =By.id("total_shipping");
    private static final By TOTAL_PRICE =By.id("total_price");
    private static final By PRODUCTS=By.cssSelector("tbody tr");

    public PaymentCartSummary(WebDriver driver){
        super(driver);
    }

    public String getTotalProductPrice(){
        return getElement(TOTAL_PRODUCTS_PRICE).getText();
    }
    public String getTotalShipping(){
        return getElement(TOTAL_SHIPPING).getText();
    }
    public String getTotalPrice(){
        return getElement(TOTAL_PRICE).getText();
    }

    public List<ProductsOnPaymentPage> getProducts(){
        List< WebElement> products =getElements(PRODUCTS);
        List<ProductsOnPaymentPage> finalProducts=new ArrayList<>();
        for(WebElement product:products){
            finalProducts.add(new ProductsOnPaymentPage(product));
        }
        return finalProducts;

    }

}
