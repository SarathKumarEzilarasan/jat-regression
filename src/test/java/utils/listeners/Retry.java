package utils.listeners;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.extent.reports.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private final static int maxRetry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxRetry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                takeScreenShot(iTestResult);
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    private void takeScreenShot(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("webDriver");
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
                ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64).getModel().getMedia().get(0));
    }


}
