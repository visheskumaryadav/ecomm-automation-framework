package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @BeforeMethod
    public void doLogin(){
        homePage.goToSignInPage().loginWithValidCredentials("vishes7576@yopmail.com","password");
    }

    @Test(description = "Validate the search result with invalid searched product")
    public void searchWithInvalidProduct(){
        getSoftAssertion().assertTrue(
                homePage.getHeader()
                        .searchProduct("23h73y7")
                        .getErrorMsg().contains("No results were found ")
        );
        getSoftAssertion().assertAll();
    }

    @Test(description = "Validate search results with valid search product")
    public void searchWithValidProduct(){
        getSoftAssertion().assertTrue(
                !homePage.getHeader()
                        .searchProduct("wom")
                        .getProductCards().isEmpty()
        );

        getSoftAssertion().assertAll();
    }
//    @Test(description = "Validate the placeholder in search box")
//    public void placeholderOfSearchBox(){
//        getSoftAssertion().assertEquals(
//                homePage.getHeader()
//                        .searchProduct()
//        );
//    }

}
