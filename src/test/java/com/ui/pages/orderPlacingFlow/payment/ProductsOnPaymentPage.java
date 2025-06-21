package com.ui.pages.orderPlacingFlow.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsOnPaymentPage {

    private final WebElement root;
    private static final By PRODUCT_IMAGE= By.className("cart_product");
    private static final By PRODUCT_DESCRIPTION=By.className("cart_description");
    private static final By PRODUCT_AVAILABILITY=By.className("cart_avail");
    private static final By PRODUCT_PRICE=By.className("price special-price");
    private static final By PRODUCT_QTY=By.cssSelector("cart_quantity");
    private static final By PRODUCT_FINAL_PRICE=By.cssSelector("td[class='cart_total']");

    public ProductsOnPaymentPage(WebElement root){
        this.root=root;
    }

    public String getProductDescription(){
        return root.findElement(PRODUCT_DESCRIPTION).getText();
    }
    public int getProductQty(){
        return Integer.parseInt(root.findElement(PRODUCT_QTY).getText());
    }
    public String getProductAvailability(){
        return root.findElement(PRODUCT_AVAILABILITY).getText();
    }
    public String getProductTotalPrice(){
        return root.findElement(PRODUCT_FINAL_PRICE).getText();
    }
}
