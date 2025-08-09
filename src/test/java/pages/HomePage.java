package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helpers;

public class HomePage extends PageBase {

    private By searchInput = By.id("search-input");
    private By searchButton = By.id("submit");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public void searchForProduct(String productName) {
        Helpers.sendKeys(searchInput, productName);
        Helpers.click(searchButton);
    }
}