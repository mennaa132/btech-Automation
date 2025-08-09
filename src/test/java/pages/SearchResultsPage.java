package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Helpers;
import static utils.Helpers.wait;

public class SearchResultsPage extends PageBase {
    private By firstProductName = By.xpath("(//div[contains(@class,'product-item')]//h3)[1]");
    private By firstProductLink = By.xpath("(//div[contains(@class,'product-item')]/a)[1]");
    private By firstProductImage = By.xpath("(//div[contains(@class,'product-item')]//img)[1]");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstProductName() {
        WebElement element = wait.until(d -> d.findElement(firstProductName));
        return element.getText().trim();
    }

    public void selectFirstProduct() {
        Helpers.click(firstProductLink);
    }

    public boolean hasSearchResults() {
        return !driver.findElements(firstProductName).isEmpty();
    }

    public boolean firstProductHasImage() {
        return Helpers.isElementDisplayed(firstProductImage);
    }
}