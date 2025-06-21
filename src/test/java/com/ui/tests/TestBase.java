package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.homepage.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {
    private static  ThreadLocal<SoftAssert>softAssertThreadLocal=new ThreadLocal<>();
    protected HomePage homePage;
    @BeforeMethod
    public void setUp(){
        homePage=new HomePage(Browser.CHROME);
        softAssertThreadLocal.set(new SoftAssert());
    }
    @AfterMethod
    public void tearDown(){
//
    softAssertThreadLocal.remove();

    homePage.quitBrowser();
    }
    public SoftAssert getSoftAssertion(){
        return softAssertThreadLocal.get();
    }


}
