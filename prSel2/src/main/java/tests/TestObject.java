package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.pages.BasePage;
import pageObject.pages.HomePage;

public class TestObject {

    @Description("Test passed description with details")
    @Test(description = "Test passed")
    public void openProductTest() {
        String query = "selenium";
        WebDriverManager.chromedriver().setup();

        new HomePage(new ChromeDriver())
                .openGoogle()
                .search(query)
                .clickProductByIndex(0)
                .clickDownloadLink();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test broken")
    public void brokenTest() {
        String query = "java";
        WebDriverManager.chromedriver().setup();

        new HomePage(new ChromeDriver())
                .openGoogle()
                .search(query)
                .clickProductByIndex(0)
                .clickDownloadLink();
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "Test failed")
    public void failedTest() {
        String query = "selenium";
        WebDriverManager.chromedriver().setup();

        new HomePage(new ChromeDriver())
                .openGoogle()
                .search(query)
                .clickProductByIndex(0)
                .checkDownloadLinkText();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}