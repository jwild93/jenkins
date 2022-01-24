package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.pages.BasePage;
import pageObject.pages.HomePage;
import pageObject.pages.SearchResultsPage;

public class TestObject {

    @Test
    public void openProductTest() {
        String query = "selenium";
        WebDriverManager.chromedriver().setup();

        new HomePage(new ChromeDriver())
                .openGoogle()
                .search(query)
                .clickProductByIndex(0)
                .clickDownloadLink();
    }

    @Test
    public void failedTest() {
        String query = "java";
        WebDriverManager.chromedriver().setup();

        new HomePage(new ChromeDriver())
                .openGoogle()
                .search(query)
                .clickProductByIndex(0)
                .clickDownloadLink();
    }

    @AfterTest
    public void closeBrowser() {
        BasePage.setDown();
    }
}