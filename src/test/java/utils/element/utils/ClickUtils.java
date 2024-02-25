package utils.element.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickUtils {
    private static Actions actions;
    private static JavascriptExecutor javascriptExecutor;

    public static void click(ChromeDriver driver, WebElement element) {
        WaitUtils.waitForVisible(driver, element);
        element.click();
    }

    public static void clickByActions(ChromeDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).click();
    }

    public static void clickByJs(ChromeDriver driver, WebElement element) {
        javascriptExecutor = driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }


}
