package testCase;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import factories.BrowserFactory;
import factories.DataProviderFactory;
import pageObjects.HomeScreen_Uscre;
import pageObjects.MyCREScreen_Uscre;

public class Verify_VelidLogin extends BaseTest {
	
	public String testCaseName = "LoginTests";
	
	
	// driver
	
	

	@Test(priority = 0, enabled = true)
	public void validLogin() throws InterruptedException {
		
		String completeTestName = testCaseName + "001";
		
		test = extent.createTest(completeTestName + "Html Report Logs");
		test.log(Status.INFO, "Application is Up & Running");
		
		driver = BrowserFactory.getBrowser("Chrome");
		test.log(Status.INFO, "Chrome browser Launched");
		
		driver.get(DataProviderFactory.getConfiguration().getApplicationUrl());
		test.info("Uscre test Application launched.");
		
		HomeScreen_Uscre homeScreen = PageFactory.initElements(driver, HomeScreen_Uscre.class);
		Thread.sleep(2000);
		
		test.info("Login Operation Started");
		homeScreen.clickSignIn1();
		Thread.sleep(2000);
		String userName = DataProviderFactory.getTestDataProvider().getUserName(completeTestName);
		String password = DataProviderFactory.getTestDataProvider().getPassword(completeTestName);
		homeScreen.sendUserName(userName);
		Thread.sleep(2000);
		homeScreen.sendPassword(password);
		Thread.sleep(2000);
		homeScreen.checkRememberMe();
		Thread.sleep(2000);
		homeScreen.clickSignIn2();
		Thread.sleep(10000);
		
		MyCREScreen_Uscre myCre = PageFactory.initElements(driver, MyCREScreen_Uscre.class);
		Assert.assertEquals(myCre.getApplicationTitle(), "Index - USCRE", "InValid crediantials : Check Username or password");
		test.pass("LogIn Succesfull as "+"UserName : "+userName+" Password : "+password);
		
		test.pass("Login Operation Completed");
		
		test.info("Logout Operation Started");
		myCre.clickLoggedinUserName();
		Thread.sleep(5000);
		myCre.clickLogout();
		Thread.sleep(5000);
		test.info("Logout Operation Completed");
	}
	
}
