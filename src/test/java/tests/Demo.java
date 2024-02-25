package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.logs.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo {
//    public static void main(String[] args) {
////        WebDriver driver;
////        String browser = "chrome";
////
////        if (browser.equals("chrome")) {
////            driver = new ChromeDriver();
////        } else {
////            driver = new FirefoxDriver();
////        }
//
//    }

    @Test
    @Parameters({"browser"})
    public void test(String browser) {
        System.out.println(browser);
    }
}
