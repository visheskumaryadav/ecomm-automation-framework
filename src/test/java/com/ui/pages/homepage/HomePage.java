package com.ui.pages.homepage;

import com.constants.Browser;
import static com.constants.Env.*;

import com.ui.pages.authenticationPage.AuthenticationPage;
import com.ui.pages.commonComponents.Header;
import com.ui.pages.commonComponents.NavigationBar;
import com.ui.pages.commonComponents.TopNotificationBar;
import com.ui.utilities.BrowserUtility;
import static com.ui.utilities.PropertiesUtils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    public TopNotificationBar topNotificationBar;
    public Header header;
    public NavigationBar navigationBar;


    public HomePage(Browser browser) {
        super(browser);
        goToWebsite(readProperty(QA,"url"));
        topNotificationBar=new TopNotificationBar(getDriver());
        header=new Header(getDriver());
        navigationBar=new NavigationBar(getDriver());
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }


}
