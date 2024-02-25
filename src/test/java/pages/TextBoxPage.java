package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='j_idt88:name']")
    public WebElement inputBox;

    @FindBy(xpath = "//input[@name='j_idt88:j_idt91']")
    private WebElement appendInputBox;

    public WebElement getAppendInputBox() {
        return appendInputBox;
    }

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement enabledInputBox;

    @FindBy(id = "j_idt88:j_idt95")
    public WebElement clearInputBox;

    @FindBy(xpath = "//input[@id='j_idt88:j_idt97']")
    public WebElement getAttributeInputBox;



}
