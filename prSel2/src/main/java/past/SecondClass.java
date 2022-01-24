package past;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SecondClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver5 = new ChromeDriver();
        driver5.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver5.manage().window().maximize();
        try {
            driver5.get("https://www.softserveinc.com/");

            driver5.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            WebElement searchInput = driver5.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("academy");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver5, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(driver5.findElements(By.xpath("//h3[@class='search-card__title']"))));

            System.out.println(results.get(0).getText().equals("IT Academy"));

            getScreenShot(driver5);

        } finally {
            driver5.quit();
        }
    }

    public static void getScreenShot(WebDriver driver) {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}













/*

L15 EXAMPLE 1
private final static Color HEX_COLOUR_BUTTON = Color.fromString("#00a046");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-link-i']")));
            System.out.println(firstResult.getText());
            Color loginButtonBackgroundColour = Color
                    .fromString(driver.findElement(By.xpath("//div[@class='rz-banner__btn rz-btn_green btn-link']"))
                            .getCssValue("background-color"));
            System.out.println(loginButtonBackgroundColour.equals(HEX_COLOUR_BUTTON));
        } finally {
            driver.quit();
        }
    }

L15 EXAMPLE 2
System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://rozetka.com.ua/notebooks/c80004/");

            WebElement selectElement = driver.findElement(By.xpath("//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']"));

            Select selectObject = new Select(selectElement);
            List<WebElement> allSelectedOptions = selectObject.getAllSelectedOptions();
            List<WebElement> allAvailableOptions = selectObject.getOptions();
            String firstSelectedOption = selectObject.getFirstSelectedOption().getText();
            Boolean doesThisAllowMultipleSelections = selectObject.isMultiple();

            selectObject.selectByIndex(3);

            String secondSelectedOption = selectObject.getFirstSelectedOption().getText();
            for (WebElement e : allSelectedOptions) {
                System.out.println("allSelectedOptions = " + e.getText());
            }
            for (WebElement e : allAvailableOptions) {
                System.out.println("SelectedOption = " + e.getText());
            }
            System.out.println("firstSelectedOption = " + firstSelectedOption);
            System.out.println("secondSelectedOption = " + secondSelectedOption);
            System.out.println("doesThisAllowMultipleSelections = " + doesThisAllowMultipleSelections);
        } finally {
            driver.quit();
        }
    }


L15 EXAMPLE 3
public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to Url
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            // Store 'box A' as source element
            WebElement sourceEle = driver.findElement(By.id("draggable"));
            // Store 'box B' as source element
            WebElement targetEle = driver.findElement(By.id("droppable"));
            int targetEleXOffset = targetEle.getLocation().getX();
            int targetEleYOffset = targetEle.getLocation().getY();
            Actions actionProvider = new Actions(driver);
            // Performs dragAndDropBy onto the  target element offset position
            actionProvider.dragAndDropBy(sourceEle, targetEleXOffset, targetEleYOffset).build().perform();
        } finally {
            driver.quit();
        }

        public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    try {
      // Navigate to Url
      driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
      // Store 'box A' as source element
      WebElement sourceEle = driver.findElement(By.id("draggable"));
      // Store 'box B' as source element
      WebElement targetEle = driver.findElement(By.id("droppable"));
      Actions actionProvider = new Actions(driver);
      actionProvider.clickAndHold(sourceEle).moveToElement(targetEle).build().perform();
      // Performs release event
      actionProvider.release().build().perform();
    } finally {
      driver.quit();
    }
  }

public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://rozetka.com.ua/notebooks/c80004/");
            WebElement firstResult = driver.findElement(By.className("goods-tile__title"));
            System.out.println(firstResult.getText());
            Actions actionProvider = new Actions(driver);
            actionProvider.contextClick(firstResult).build().perform();
        } finally {
            driver.quit();
        }
    }




L15 EXAMPLE 4
  public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            driver.get("https://www.softserveinc.com/");

            driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("academy");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@class='search-card__title']"))));

            System.out.println(results.get(0).getText().equals("IT Academy"));

            getScreenShot(driver);

        } finally {
            driver.quit();
        }
    }

    public static void getScreenShot(WebDriver driver) {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








EXAMPLE 1
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
            WebElement element = driver.findElement(By.xpath("//button[@class='btn-link-i']"));
            System.out.println(element.isDisplayed());
        } finally {
            driver.quit();
        }



EXAMPLE 2
 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            // Initialize and wait till element became clickable - timeout in 10 seconds
            driver.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-link-i']")));
            System.out.println(firstResult.getText());
        } finally {
            driver.quit();
        }


 EXAMPLE 3
public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        try {
            driver.get("https://bt.rozetka.com.ua/?gclid=Cj0KCQiAwqCOBhCdARIsAEPyW9ndZQyNph8rRLQirCzr6shTnIAOCDohBrlqUajYNaciIrh0JC2izEsaAsMrEALw_wcB");
            WebElement element = driver.findElement(By.xpath("//button[@class='btn-link-i']"));
            System.out.println(isElementLoaded(driver, element));
        } finally {
            driver.quit();
        }
    }

    public static boolean isElementLoaded(WebDriver driver, WebElement loadElement) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds((long) 20.0))
                .pollingEvery(Duration.ofSeconds((long) 1.0))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(loadElement));
        return loadElement.isDisplayed();
    }



Lecture 1
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/");

        driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

        WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
        searchInput.sendKeys("academy");
        searchInput.sendKeys(Keys.ENTER);

        List<WebElement> results = driver.findElements(By.xpath("//h3[@class='search-card__title']"));
        String firstResultTitle = results.get(0).getText();

        System.out.println(firstResultTitle.equals("IT Academy"));
        driver.quit();



Lecture 2
        public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/");

        driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='form-input__text']")));
        WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
        searchInput.sendKeys("academy");
        searchInput.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='search-card__title']")))
                .isDisplayed();
        List<WebElement> results = driver.findElements(By.xpath("//h3[@class='search-card__title']"));
        String firstResultTitle = results.get(0).getText();

        System.out.println(firstResultTitle.equals("IT Academy"));
        driver.quit();
    }


  Lecture 3
System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.softserveinc.com/");

driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
searchInput.sendKeys("academy");
searchInput.sendKeys(Keys.ENTER);

List<WebElement> results = driver.findElements(By.xpath("//h3[@class='search-card__title']"));
String firstResultTitle = results.get(0).getText();

System.out.println(firstResultTitle.equals("IT Academy"));
driver.quit();



 */