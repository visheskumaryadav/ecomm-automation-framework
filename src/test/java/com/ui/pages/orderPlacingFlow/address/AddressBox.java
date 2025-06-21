package com.ui.pages.orderPlacingFlow.address;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBox {
    private final WebDriver driver;
    private final WebElement root;

    private static final By NAME = By.tagName("li");  // first <li> usually name
    private static final By ADDRESS_UPDATE_BTN = By.cssSelector("ul > li > a[title='Update']");

    public AddressBox(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }

    public String getFullAddressText() {
        return root.getText();  // Returns all lines
    }

    public void clickUpdate() {
        root.findElement(ADDRESS_UPDATE_BTN).click();
    }

}
