package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.homepage.HomePage;
import com.ui.utilities.LambdaTestUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestBase {
    private static  ThreadLocal<SoftAssert>softAssertThreadLocal=new ThreadLocal<>();
    private boolean isLambdaTest;
    protected HomePage homePage;
    /*
    If we want to pass the parameter with the help of testng then use @Parameter annotation
    But if just want to execute the test only directly then we can use @Optional annotation
     */
    @Parameters({"browser","isLambdaTest","isHeadLess"})
    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadLess, ITestResult result){
        this.isLambdaTest=isLambdaTest;
        WebDriver lambdaDriver;
        if(isLambdaTest){
            lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName());
            homePage =new HomePage(lambdaDriver);
        }else{
            homePage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadLess);
        }

        softAssertThreadLocal.set(new SoftAssert());
    }
    @AfterMethod
    public void tearDown(){
        softAssertThreadLocal.remove();
        if(isLambdaTest){
            LambdaTestUtility.quitSession();
        }else{
            homePage.quitBrowser();
        }
    softAssertThreadLocal.remove();


    }
    public SoftAssert getSoftAssertion(){
        return softAssertThreadLocal.get();
    }


}
