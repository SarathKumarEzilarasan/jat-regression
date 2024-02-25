package utils.listeners;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import tests.BaseTest;
import utils.extent.reports.ExtentManager;
import utils.extent.reports.ExtentTestManager;
import utils.logs.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestNgListener implements ITestListener {
    private WebDriver driver;

    public void onTestStart(ITestResult result) {
        Log.info(result.getName() + " test is starting");
    }

    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " test is passed");
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        Log.info(result.getName() + " test is failed");
        //taking screenshot
        takeScreenShotExtentReport(result);
//        takeScreenShot(result);
    }

    private void takeScreenShotExtentReport(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("webDriver");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File destFolder = new File(System.getProperty("user.dir"));
        String reportDirectory = destFolder.getAbsolutePath() + "/target/failure_screenshots/";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File destFile = new File(reportDirectory + result.getName()
                + "_" + formatter.format(calendar.getTime()) + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);

            ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
                    ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64).getModel().getMedia().get(0));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takeScreenShot(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("webDriver");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFolder = new File(System.getProperty("user.dir"));
        String reportDirectory = destFolder.getAbsolutePath() + "/target/failure_screenshots/";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File destFile = new File(reportDirectory + result.getName()
                + "_" + formatter.format(calendar.getTime()) + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("<a href='" + destFile.getAbsolutePath()
                    + "'><img src='" + destFile.getAbsolutePath() + "'  height='100' width='100' /></a>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        Log.info(context.getName() + " test start method");
    }

    public void onFinish(ITestContext context) {
        Log.info(context.getName() + " test finish method");
        ExtentManager.extentReports.flush();
    }
}
