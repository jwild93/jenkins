package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By searchInput = new By.ByXPath("//input[@class='gLFyf gsfi']");
    private By searchButton = new By.ByClassName("gNO89b");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openGoogle(){
        driver.get("https://www.google.com.ua/");
        return this;
    }

    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        driver.findElement(searchInput).submit();
        return new SearchResultsPage(driver);
    }
}