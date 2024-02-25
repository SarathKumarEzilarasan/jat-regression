package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListPage {
    // POM -> Page Object Model ---> Page Factory Model --> design pattern
    WebDriver driver;

    public ListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"product-name\"]")
    public WebElement product;

    @FindBy(xpath = "//div[@class=\"product-name\"]")
    public List<WebElement> products;


}
