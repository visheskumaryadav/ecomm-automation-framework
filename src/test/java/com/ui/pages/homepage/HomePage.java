package com.ui.pages.homepage;

import com.constants.Browser;
import static com.constants.Env.*;

import com.ui.pages.authenticationPage.CreateAccountSection;
import com.ui.pages.authenticationPage.LoginSection;
import com.ui.pages.commonComponents.Header;
import com.ui.pages.commonComponents.NavigationBar;
import com.ui.pages.commonComponents.TopNotificationBar;
import com.ui.utilities.BrowserUtility;
import static com.ui.utilities.PropertiesUtils.*;

import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    private TopNotificationBar topNotificationBar;
    private Header header;
    private NavigationBar navigationBar;


    public HomePage(Browser browser) {
        super(browser);
        goToWebsite(readProperty(QA,"url"));
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public TopNotificationBar getTopNotificationBar() {
        return new TopNotificationBar(getDriver());
    }

    public Header getHeader() {
        return new Header(getDriver());
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(getDriver());
    }

    public LoginSection goToSignInPage(){
        return new TopNotificationBar(getDriver()).goToSignInPage().getLoginSection();
    }
    public CreateAccountSection goToCreateAccountPage(){
        return new TopNotificationBar(getDriver()).goToSignInPage().getCreateAccountSection();
    }
}
