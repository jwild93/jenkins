package past;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Test5 {
    private final static Color HEX_COLOUR_BUTTON = Color.fromString("#00a046");
    private final static Color HEX_COLOUR_BUTTON_WRONG = Color.fromString("#02a046");

    @Test
    public void softAssert(){
        SoftAssert softAssertion = new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertTrue(false);
        System.out.println("softAssert Method Was Executed");
        softAssertion.assertAll();
    }
    @Test
    public void hardAssert(){
        System.out.println("hardAssert Method Was Started");
        assertTrue(false);
        System.out.println("hardAssert Method Was Executed");
    }

    @Test
    public void softAssert2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver2 = new ChromeDriver();
        try {
            driver2.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
            WebElement firstResult = new WebDriverWait(driver2, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-link-i']")));
            System.out.println(firstResult.getText());
            Color loginButtonBackgroundColour = Color
                    .fromString(driver2.findElement(By.xpath("//div[@class='rz-banner__btn rz-btn_green btn-link']"))
                            .getCssValue("background-color"));
            System.out.println(loginButtonBackgroundColour.equals(HEX_COLOUR_BUTTON));

            SoftAssert softAssertion = new SoftAssert();
            System.out.println("softAssert Method1 Was Started");
            softAssertion.assertEquals(loginButtonBackgroundColour, HEX_COLOUR_BUTTON_WRONG);
            System.out.println("softAssert Method2 Was Started");
            softAssertion.assertEquals(loginButtonBackgroundColour, HEX_COLOUR_BUTTON);
            System.out.println("softAssert Method3 Was Started");
            softAssertion.assertEquals(firstResult.getText(), "Перейти");
            System.out.println("softAssert Method4 Was Started");
            softAssertion.assertEquals(firstResult.getText(), "Перейти еще");
            System.out.println("softAssert Method Was Executed");
            softAssertion.assertAll();
        } finally {
            driver2.quit();
        }
    }
}
