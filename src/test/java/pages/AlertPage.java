package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "j_idt88:j_idt91")
    public WebElement simpleAlert;

    @FindBy(id = "j_idt88:j_idt104")
    public WebElement promptAlert;


    public void login(){

    }

}
