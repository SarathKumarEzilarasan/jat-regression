package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    //POM -> Page Object Model --> Page Factory Model

//driver.findElement(By.id("j_idt89:j_idt90")).click();

    WebDriver driver;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public By by = By.id("j_idt89:j_idt90");
//driver.findElement(By.xpath("//div[@id=\"j_idt89:messages\"]//li"))

    @FindBy(id = "j_idt89:j_idt90")
    public WebElement element;

    @FindBy(xpath = "//div[@id='j_idt89:messages']//li")
    public WebElement popUpMessage;


}
