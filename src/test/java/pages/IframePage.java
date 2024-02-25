package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IframePage {
    WebDriver driver;

    public IframePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Click")
    public WebElement button;

    @FindBy(xpath = "//iframe[@src=\"page.xhtml\"]")
    public WebElement childFrame;

    @FindBy(xpath = "//iframe[@src=\"framebutton.xhtml\"]")
    public WebElement grandChildFrame;

    @FindBy(id = "Click")
    public List<WebElement> buttons;

}
