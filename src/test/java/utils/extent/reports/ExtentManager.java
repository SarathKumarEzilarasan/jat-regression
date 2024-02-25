package utils.extent.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports createExtentReports(){
        ExtentSparkReporter spark = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/extent-reports/extent-report.html");
        spark.config().setReportName("Leaf Ground Test Report");
        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Website","Leafground.com");
        extentReports.setSystemInfo("Organisation","test-company");
        return extentReports;
    }

}
