package com.ui.pages.productDetailsPage;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoBox extends BrowserUtility {
    private static final By PRODUCT_NAME = By.cssSelector("h1[itemprop='name']");
    private static final By REFERENCE = By.id("product_reference");
    private static final By CONDITION = By.id("product_condition");
    private static final By AVAILABILITY_LABEL = By.cssSelector("#availability_value");
    private static final By DESCRIPTION = By.cssSelector("#short_description_content");
    private static final By QUANTITY_INPUT = By.id("quantity_wanted");
    private static final By SIZE_DROPDOWN = By.id("group_1");
    private static final By COLOR_BLACK = By.id("color_11");
    private static final By COLOR_WHITE = By.id("color_8");
    private static final By ADD_TO_CART_BTN = By.id("add_to_cart");


    public ProductInfoBox(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getElement(PRODUCT_NAME).getText();
    }

    public String getReference() {
        return  getElement(REFERENCE).getText();
    }

    public String getCondition() {
        return  getElement(CONDITION).getText();
    }

    public String getAvailabilityStatus() {
        return  getElement(AVAILABILITY_LABEL).getText();
    }

    public String getShortDescription() {
        return  getElement(DESCRIPTION).getText();
    }
    public void setQuantity(int qty) {
        clear(QUANTITY_INPUT);
        enterInTextBox(QUANTITY_INPUT,String.valueOf(qty));
    }
    public void selectSize(String sizeText) {
        selectDropdown(SIZE_DROPDOWN,sizeText);
    }

    public ProductInfoBox selectColorBlack() {
        click(COLOR_BLACK);
        return this;
    }

    public ProductInfoBox selectColorWhite() {
        click(COLOR_WHITE);
        return this;
    }
    public AddToCartPopup clickToAddInCart() {
        click(ADD_TO_CART_BTN);
        return new AddToCartPopup(getDriver());
    }
}
