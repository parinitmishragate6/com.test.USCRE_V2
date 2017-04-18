package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factories.BrowserFactory;
import utility.Helper;



public class BaseTest {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/UscreReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Name", "Uscre Report");
		extent.setSystemInfo("OS", "Windows 7");
		extent.setSystemInfo("Host Name", "Parinit Mishra");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Parinit Mishra");
		
		htmlReporter.config().setDocumentTitle("Extent Report V_3.0 for Uscre Test Server");
		htmlReporter.config().setDocumentTitle("Uscre Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Helper.captureScreenshot(driver, "ScreenshotNameFullPage");
			test.fail(MarkupHelper.createLabel(result.getName() + " TestCase Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Screenshot below " + test.addScreenCaptureFromPath(screenshotPath));
		
			BrowserFactory.colseWebDriver();
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + " TestCase passed", ExtentColor.GREEN));
		}
		else {
			test.skip(MarkupHelper.createLabel(result.getName() + " TestCase skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		BrowserFactory.colseWebDriver();
	}
	
}
