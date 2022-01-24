package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByXPath("//h3[@class='LC20lb MBeuO DKV0Md']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductByIndex(int index) {
        List<WebElement> resultsWebElements = driver.findElements(results);
        resultsWebElements.get(index).click();
        return new ProductPage(driver);
    }
}