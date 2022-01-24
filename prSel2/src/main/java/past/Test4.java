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

public class Test4 {

    @Test
    public void verifyData() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver3 = new ChromeDriver();
        driver3.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver3.manage().window().maximize();
        try {
            driver3.get("https://www.softserveinc.com/");

            driver3.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            WebElement searchInput = driver3.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("academy");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver3, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(driver3.findElements(By.xpath("//h3[@class='search-card__title']"))));

            assertEquals(results.get(0).getText(), "IT Academy");
            //assertEquals(results.get(0).getText(), "ITs Academy", "First result title is not IT Academy");
        } finally {
            driver3.quit();
        }
    }
}
