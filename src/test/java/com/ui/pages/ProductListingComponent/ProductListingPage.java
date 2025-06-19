package com.ui.pages.ProductListingComponent;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductListingPage extends BrowserUtility {

    private static By PRODUCT_CARD_LOCATOR= By.cssSelector(".product-container");
    private static By COMPARE_BTN_LOCATOR= By.cssSelector(".top-pagination-content .bt_compare");

    public ProductListingPage(WebDriver driver){
        super(driver);

    }

    public List<ProductCard> getProductCards(){
        List<WebElement> cards=getElements(PRODUCT_CARD_LOCATOR);
        List<ProductCard> productCards=new ArrayList<>();
        for(WebElement card:cards){
            productCards.add(new ProductCard(card,getDriver()));
        }
        return productCards;
    }

}
