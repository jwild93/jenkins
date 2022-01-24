package past;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Test6 {
    private final static Color HEX_COLOUR_BUTTON = Color.fromString("#00a046");
    private final static Color HEX_COLOUR_BUTTON_WRONG = Color.fromString("#02a046");

    public static WebDriver driver1 = null;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
    }

    @Test
    public void softAssert2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver1.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
        WebElement firstResult = new WebDriverWait(driver1, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-link-i']")));
        System.out.println(firstResult.getText());
        Color loginButtonBackgroundColour = Color
                .fromString(driver1.findElement(By.xpath("//div[@class='rz-banner__btn rz-btn_green btn-link']"))
                        .getCssValue("background-color"));
        System.out.println(loginButtonBackgroundColour.equals(HEX_COLOUR_BUTTON));

        SoftAssert softAssertion = new SoftAssert();
        System.out.println("softAssert Method1 Was Started");
        //softAssertion.assertEquals(loginButtonBackgroundColour, HEX_COLOUR_BUTTON_WRONG);
        System.out.println("softAssert Method2 Was Started");
        softAssertion.assertEquals(loginButtonBackgroundColour, HEX_COLOUR_BUTTON);
        System.out.println("softAssert Method3 Was Started");
        softAssertion.assertEquals(firstResult.getText(), "Перейти");
        System.out.println("softAssert Method4 Was Started");
       // softAssertion.assertEquals(firstResult.getText(), "Перейти еще");
        System.out.println("softAssert Method Was Executed");
        softAssertion.assertAll();
    }

    @AfterTest
    public void setDown() {
        driver1.quit();
    }
}