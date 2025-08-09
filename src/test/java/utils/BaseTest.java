package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchResultsPage searchResults;
    protected ShoppingCartPage cartPage;

    @BeforeMethod
    public void setup() {
        driver = initDriver();
        initPages();
        homePage.navigateToHomePage("https://www.btech.com");
    }

    protected WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");  // Important for newer Chrome versions
        return new ChromeDriver(options);
    }

    protected void initPages() {
        homePage = new HomePage(driver);
        searchResults = new SearchResultsPage(driver);
        cartPage = new ShoppingCartPage(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}