package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helpers;


public class ShoppingCartPage extends PageBase {

    private By cartItem = By.xpath("//*[contains(@class, 'cart-item')]");

    private By cartItemImage = By.xpath("//*[contains(@class, 'cart-item')]//img");
    private By addToCartButton = By.id("add-to-cart-button");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductText(){
        return Helpers.getText(cartItem);
    }


    public boolean isProductImageVisible() {
        return Helpers.isElementDisplayed(cartItemImage);
    }
    public void addToCart(){
        Helpers.click(addToCartButton);
    }
    public void navigateToCart() {
        Helpers.navigateTo("https://www.btech.com/cart");
    }
}