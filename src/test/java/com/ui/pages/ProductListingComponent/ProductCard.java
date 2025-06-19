package com.ui.pages.ProductListingComponent;

import com.ui.pages.productDetailsPage.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
ProductCard class denotes a single product in the product listing so if we want to know name or price of
the product without going into product details section the we can use this. It provides surface level
data.
 */
public class ProductCard{
   private  WebElement productRoot;
   private WebDriver driver;
    private static final By PRODUCT_NAME_LOCATOR = By.cssSelector(".product-name");
    private static final By PRODUCT_PRICE_LOCATOR = By.cssSelector(".right-block .price");
    private static final By ADD_TO_CART_BTN_LOCATOR = By.cssSelector(".ajax_add_to_cart_button");
    private static final By DISCOUNT_LABEL_LOCATOR = By.cssSelector(".price-percent-reduction");
    private static final By PRODUCT_AVAILABILITY_LOCATOR = By.cssSelector(".availability span");
    private static final By QUICK_VIEW_LOCATOR = By.cssSelector(".quick-view");

    public ProductCard(WebElement productRoot, WebDriver driver){
        this.productRoot =productRoot;
        this.driver=driver;
    }
    public String getProductName() {
        return productRoot.findElement(PRODUCT_NAME_LOCATOR).getText();
    }

    public String getProductPrice() {
        return productRoot.findElement(PRODUCT_PRICE_LOCATOR).getText();
    }

    public boolean hasDiscount() {
        return !productRoot.findElements(DISCOUNT_LABEL_LOCATOR).isEmpty();
    }

    public boolean isOutOfStock() {
        return productRoot.findElement(PRODUCT_AVAILABILITY_LOCATOR).getText().toLowerCase().contains("out of stock");
    }

    public void clickQuickView() {
        productRoot.findElement(QUICK_VIEW_LOCATOR).click(); // might need JS hover
    }

    public void clickAddToCart() {
        productRoot.findElement(ADD_TO_CART_BTN_LOCATOR).click();
    }

    //Redirects to product details page
    public ProductDetailsPage click() throws InterruptedException {
        productRoot.click();
        return new ProductDetailsPage(driver);
    }

}
