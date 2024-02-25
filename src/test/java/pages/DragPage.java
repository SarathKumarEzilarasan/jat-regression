package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragPage {
    WebDriver driver;

    public DragPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "form:conpnl")
    public WebElement draggableBox;

    @FindBy(id = "form:drag_content")
    public WebElement smallBox;

    @FindBy(id = "form:drop")
    public WebElement bigBox;



}
