package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.*;
import utils.props.QaProps;
import utils.props.TestDataReader;
import utils.props.TestDataReaderJson;
import utils.WebDriverManager;

public class BaseTest {

    WebDriver driver;
    ListPage listPage;
    TextBoxPage textBoxPage;

    MessagePage messagePage;
    IframePage iframePage;
    AlertPage alertPage;
    DragPage dragPage;

//OOPS -> Inheritance

    String url;
    WebDriverManager webDriverManager;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(ITestContext context,String browser) {
        webDriverManager = new WebDriverManager(context, browser);
        driver = (WebDriver) context.getAttribute("webDriver");
        listPage = new ListPage(driver);
        textBoxPage = new TextBoxPage(driver);
        messagePage = new MessagePage(driver);
        iframePage = new IframePage(driver);
        alertPage = new AlertPage(driver);
        dragPage = new DragPage(driver);
        driver.get("https://www.leafground.com/input.xhtml");
        driver.manage().window().maximize();
        QaProps.init();
        TestDataReader.init();
        TestDataReaderJson.init();
        url = QaProps.getProperty("url");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
