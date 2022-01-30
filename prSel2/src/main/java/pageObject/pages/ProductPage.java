package pageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class ProductPage extends BasePage {

    @FindBy(css = ".product__heading .product__title")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/downloads']")
    private WebElement downloadLink;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    @Step("Click Download link")
    public CartPage clickDownloadLink() {
        downloadLink.click();
        return new CartPage(driver);
    }

    @Step("Check Download link present")
    public ProductPage checkDownloadLinkPrsent() {
        assertTrue(downloadLink.isDisplayed(), "Download link is not present");
        return this;
    }
}