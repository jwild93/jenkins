package past;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {

    @Parameters({ "datasource", "jdbcDriver" })
    @BeforeMethod
    public void beforeTest(String ds, String driver) {
        System.out.println("Datasource: " + ds);
        System.out.println("JdbcDriver: " + driver);
    }

    @Parameters({"first-title", "search" })
    @Test
    public void testSingleString(String firstTitle, String search) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver4 = new ChromeDriver();
        driver4.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver4.manage().window().maximize();
        try {
            driver4.get("https://www.softserveinc.com/");

            driver4.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            WebElement searchInput = driver4.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys(search);
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver4, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(driver4.findElements(By.xpath("//h3[@class='search-card__title']"))));

            System.out.println(results.get(0).getText().equals(firstTitle));

            SecondClass.getScreenShot(driver4);

        } finally {
            driver4.quit();
        }
    }

    //Parameters can be declared optional with the Optional annotation:
    @Parameters("db")
    @Test
    public void testNonExistentParameter(@Optional("mysql") String db) {
        System.out.println("db: " + db);
    }
}
