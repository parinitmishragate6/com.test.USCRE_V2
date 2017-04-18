package factories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * This class has following responsibilities
 * -> To create required WebDriver
 * -> To maintain an instance of a WebDriver
 * 
 */

public class BrowserFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfiguration().getFirefoxServerPath());
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfiguration().getIEServerPath());
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfiguration().getChromeServerPath());
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getBrowser() {
		return driver;
	}
	
	public static void colseWebDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
	
	public static void colseWebDriver(WebDriver driver) {
		driver.close();
		driver.quit();
		driver = null;
	}
}
