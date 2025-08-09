package testCases;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import utils.BaseTest;

public class ProductPurchaseTC extends BaseTest {

    @Test(testName = "Purchase Product Flow")
    public void TC01_ProductPurchaseFlow() {
        //Search for iphone16
        homePage.searchForProduct("iphone16");
        //verify and select
        assertTrue(searchResults.hasSearchResults(), "No search results found");
        assertTrue(searchResults.firstProductHasImage(),"Product should have image");


        String productName = searchResults.getFirstProductName();
        assertNotNull(productName, "Product name should not be null");
        assertFalse(productName.isEmpty(), "Product name should not be empty");

        searchResults.selectFirstProduct();

        cartPage.addToCart();

        cartPage.navigateToCart();
        assertTrue(cartPage.getProductText().contains(productName));
    }

}