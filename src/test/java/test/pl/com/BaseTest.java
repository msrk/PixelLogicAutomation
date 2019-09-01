package test.pl.com;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pl.util.TestDataLoader;
import model.pl.com.GoogleSignIn;
import model.pl.com.MailPage;
import model.pl.com.TravelCreateForm;
import model.pl.com.TravelHomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        // Create an object of Extent Reports
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "phptravels");

        extent.setSystemInfo("User Name", "M Komy");
        htmlReporter.config().setDocumentTitle("Pixel Logic ");
        // Name of the report
        htmlReporter.config().setReportName("Pixel Logic ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.DARK);
    }

    //This method is to capture the screenshot and return the path of the screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
        DesiredCapabilities chCapabilities = DesiredCapabilities.chrome();
        ChromeOptions opch = new ChromeOptions();


        opch.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(opch);
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }




    List<Object[]> testData = new ArrayList<Object[]>();







    public List<Object[]> getTestDataAsObjectArray(String filename) {
        List<Object[]> data = new ArrayList<Object[]>();
        TestDataLoader loader = new TestDataLoader(filename);
        loader.loadData();
        HashMap<String, HashMap<String, String>> allData = loader.getTestData();

        Iterator<Map.Entry<String, HashMap<String, String>>> entries = allData
                .entrySet().iterator();
        HashMap<String, String> row = new HashMap<String, String>();
        while (entries.hasNext()) {

            Map.Entry<String, HashMap<String, String>> entry = entries.next();
            row = entry.getValue();
            data.add(new Object[]{ row});
        }

        return data;
    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(driver, result.getName());
            //To add it in the extent report
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
