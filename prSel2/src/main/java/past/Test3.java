package past;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Test3 {
    @DataProvider(name = "test3")
    public Object[][] createData1() {
        return new Object[][] {
                { "academy", "IT Academy" },
                { "qa", "SoftServe performed QA Consulting to assess the QA processes  - Resources | SoftServe"},
        };
    }


    @Test(dataProvider = "test3")
    public void verifyData(String search, String firstTitle) {
        assertEquals(firstTitle, "IT Academy", "wrong");
        assertEquals(search, "IT Academy");
        System.out.println("search: " + search);
        System.out.println("firstTitle: " + firstTitle);
    }
}
