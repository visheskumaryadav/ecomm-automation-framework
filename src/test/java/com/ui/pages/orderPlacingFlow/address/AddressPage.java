package com.ui.pages.orderPlacingFlow.address;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage extends BrowserUtility {

    public final AddressBox deliveryAddress;
    public final AddressBox billingAddress;

    private static final By DELIVERY_BOX = By.cssSelector("ul#address_delivery");
    private static final By BILLING_BOX = By.cssSelector("ul#address_invoice");

    private static final By ADDRESS_DROPDOWN = By.id("id_address_delivery");
    private static final By SAME_ADDRESS_CHECKBOX = By.id("addressesAreEquals");
    private static final By COMMENT_TEXTAREA = By.name("message");

    private static final By CONTINUE_SHOPPING_LINK = By.cssSelector("a.button-exclusive");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.name("processAddress");

    public AddressPage(WebDriver driver) {
        super(driver);
        this.deliveryAddress = new AddressBox(getDriver(), driver.findElement(DELIVERY_BOX));
        this.billingAddress = new AddressBox(getDriver(), driver.findElement(BILLING_BOX));
    }

    public void enterOrderComment(String comment) {
        enterInTextBox(COMMENT_TEXTAREA,comment);
    }

    public void uncheckSameAddressIfChecked() {
        WebElement checkbox = getElement(SAME_ADDRESS_CHECKBOX);
        if (checkbox.isSelected()) {
            click(checkbox);
        }
    }

    public void proceedToCheckout() {
        click(PROCEED_TO_CHECKOUT_BTN);
    }

    public void clickContinueShopping() {
        click(CONTINUE_SHOPPING_LINK);
    }
    public void selectAddressFromDropdown(String address){
        selectDropdown(ADDRESS_DROPDOWN,address);
    }
}
