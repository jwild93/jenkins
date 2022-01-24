package past;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String searchFieldXpath = "//input[@type=\"text\"]";
        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("rozetka ua");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        searchElement.submit();

        WebElement searchResults = driver.findElement(By.xpath("//div[@class='yuRUbf']//a[@href='https://rozetka.com.ua/']//h3[@class='LC20lb MBeuO DKV0Md']"));
        searchResults.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());

        WebElement searchField = driver.findElement(By.xpath("//input[@class]"));
        searchField.click();
        searchField.sendKeys("карамель соленая spell с ванилью 500");
        System.out.println("Search field is displayed " + searchField.isDisplayed());

        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"button button_color_green button_size_medium search-form__submit ng-star-inserted\"]"));
        searchButton.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());

        WebElement chooseProduct = driver.findElement(By.xpath("//img[@src=\"https://content2.rozetka.com.ua/goods/images/big_tile/27924167.jpg\"]"));
        System.out.println("Search product is displayed " + chooseProduct.isDisplayed());
        System.out.println("Product name " + driver.getTitle());
        chooseProduct.click();
        driver.navigate().refresh();

        WebElement buyButton = driver.findElement(By.xpath("//div[2]/rz-product-main-info/div[2]/div/ul/li[1]/app-product-buy-btn/app-buy-button/button"));
        System.out.println("Search button is displayed " + buyButton.isDisplayed());
        buyButton.click();

        driver.close();
    }
}


















/*
//input[@name="btnK"] -  находит два элемента

//div[@class="FPdoLc lJ9FBc"]//input[@name="btnK"] - находит уже один элемент

//div[@class="FPdoLc lJ9FBc"]//input[@value="Мені пощастить"]  - 1 элемент



System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String searchFieldXpath = "//input[@title='Search']";

        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("SoftServe");
        searchElement.submit();

        driver.close();












        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String searchFieldXpath = "//input[@title='Search']";

        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("automation");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        Thread.sleep(10000);
        searchElement.submit();

        WebElement searchResults = driver.findElement(By.id("rso"));
        String firstResultTitle = searchResults.findElement(By.xpath("//a/h3")).getText();
        System.out.println("First result title is " + firstResultTitle);
        List<WebElement> allResultsTitles = searchResults.findElements(By.xpath("//a/h3"));
        List<WebElement> allMenus = driver.findElements(By.className("hdtb-mitem"));
        Thread.sleep(10000);
        System.out.println("Current URL is " + driver.getCurrentUrl());
        for (WebElement v : allMenus) {
            System.out.println("Menu title:");
            System.out.println(v.getText());
        }
        allResultsTitles.get(0).click();
        driver.close();

 */