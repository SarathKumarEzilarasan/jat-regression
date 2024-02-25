package utils.extent.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.createExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static ExtentTest startTest(String testName, String desc) {
        ExtentTest extentTest = extent.createTest(testName, desc);
        extentTestMap.put(Thread.currentThread().getId(), extentTest);
        return extentTest;
    }
}

//threads -> id,test