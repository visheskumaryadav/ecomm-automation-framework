package com.ui.pages.commonComponents;

import com.ui.pages.ProductListingComponent.ProductListingPage;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BrowserUtility {
    private static final By LOGO_LOCATOR = By.cssSelector("#header_logo");
    private static final By SEARCH_BOX_LOCATOR = By.id("search_query_top");
    private static final By SEARCH_BUTTON_LOCATOR = By.name("submit_search");
    private static final By CART_ICON_LOCATOR = By.cssSelector(".shopping_cart > a");
    private static final By CART_ITEM_COUNT_LOCATOR = By.cssSelector(".ajax_cart_quantity");
    private static final By SEARCH_INPUT_FIELD_LOCATOR= By.cssSelector("#search_query_top");


    public Header(WebDriver driver){
        super(driver);
    }


    public ProductListingPage searchProduct(String productName){
        enterInTextBox(SEARCH_BOX_LOCATOR,productName);
        click(SEARCH_BUTTON_LOCATOR);
        return new ProductListingPage(getDriver());
    }

}
