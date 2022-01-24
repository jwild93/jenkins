package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public CartPage clickDownloadLink() {
        downloadLink.click();
        return new CartPage(driver);
    }
}