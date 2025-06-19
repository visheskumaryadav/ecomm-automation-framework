package com.ui.tests;

import com.constants.Gender;
import com.ui.pages.ProductListingComponent.ProductListingPage;
import com.ui.pages.commonComponents.NavigationBar;
import com.ui.pages.commonComponents.TopNotificationBar;
import com.ui.pages.productDetailsPage.ProductInfoBox;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class DemoTest extends TestBase {
private ProductListingPage wom;
//    @Test
//    public void test1(){
//        homePage.goToSignInPage().getCreateAccountSection()
//                .createAccountWithEmail("abv@gmail.com")
//                .addPersonalInfo(Gender.MALE,"ram","kumar","1234567");
//
//        getSoftAssertion().assertTrue(true);
//    }
//
//    @Test
//    public void test2(){
//        homePage.goToSignInPage();
//        getSoftAssertion().assertTrue(true);
//    }
//    @Test
//    public void test3(){
//        homePage.goToSignInPage().getCreateAccountSection().createAccountWithEmail("ff34@gmail.com");
//        getSoftAssertion().assertTrue(true);
//    }
//
//    @Test
//    public void test4(){
//        homePage.goToSignInPage().getCreateAccountSection().createAccountWithEmail("yyw@gmail.com")
//                .addPersonalInfo(Gender.MALE,"sumit","kumar","1234567").clickAddMyFirstAddress();
//
//    }
//    @Test
//    public void test1(){
////        homePage.topNotificationBar.goToSignInPage().getCreateAccountSection().createAccountWithEmail("ff@gmwi.com");
////    homePage.navigationBar.clickWomenTab();
//
//        homePage.topNotificationBar.goToSignInPage().getLoginSection().doSignInWith("vishes@yopmail.com","password");
//    }
    @BeforeMethod
    public void method1(){
         wom= homePage.header.searchProduct("wom");
    }
    @Test
    public void test2() throws InterruptedException {


        ProductInfoBox productInfo = wom.getProductCards().get(1).click().getProductInfo();
        System.out.println(productInfo.getAvailabilityStatus());
        System.out.println(productInfo.selectColorWhite().getAvailabilityStatus());
        productInfo.clickToAddInCart().clickProceedToCheckout();


    }
}
