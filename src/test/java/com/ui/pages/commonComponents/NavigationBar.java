package com.ui.pages.commonComponents;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BrowserUtility {
    private static final By WOMEN_TAB = By.linkText("WOMEN");
    private static final By DRESSES_TAB = By.linkText("DRESSES");
    private static final By T_SHIRTS_TAB = By.linkText("T-SHIRTS");
    private static final By BLOG_TAB = By.linkText("BLOG"); // Optional if present

    public NavigationBar(WebDriver driver){
        super(driver);
    }

    public void clickWomenTab() {
        click(WOMEN_TAB);
    }

    public void clickDressesTab() {
        click(DRESSES_TAB);
    }

    public void clickTShirtsTab() {
       click(T_SHIRTS_TAB);
    }

    public void clickBlogTab() {
        click(BLOG_TAB);
    }
}
