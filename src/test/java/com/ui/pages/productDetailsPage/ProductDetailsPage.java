package com.ui.pages.productDetailsPage;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BrowserUtility {
    private final ProductInfoBox productInfo;
//    public final ProductImageGallery gallery;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.productInfo = new ProductInfoBox(driver);
//        this.gallery = new ProductImageGallery(driver);
    }


    public ProductInfoBox getProductInfo() {
        return productInfo;
    }
}
