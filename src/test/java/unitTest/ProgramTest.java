package unitTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigurationDataProvider;
import dataProvider.MiscTestDataExcel;
import dataProvider.TestDataProviderExcel;
import factories.BrowserFactory;
import factories.DataProviderFactory;

public class ProgramTest {
	public static void main(String[] args) throws InterruptedException {
		ConfigurationDataProvider cdp = new ConfigurationDataProvider();
		System.out.println(cdp.getApplicationUrl());
		System.out.println(cdp.getChromeServerPath());
		System.out.println(cdp.getBrowsers());
		
		System.out.println("-----------------------");
		
		try {
			TestDataProviderExcel tdp = new TestDataProviderExcel("ApplicationTestData\\TestData.xls", 0);
			System.out.println(tdp.getFirstName("UnitTest"));
			System.out.println(tdp.getLastName("UnitTest"));
			System.out.println(tdp.getSearchKey("UnitTest"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		MiscTestDataExcel mis = new MiscTestDataExcel("ApplicationTestData\\AppData.xlsx");
		DataProviderFactory.getMiscTestData().getdataIndex(0, 0, 0);
		
		String indexData = mis.getdataIndex(0, 2, 2);
		String nameData = mis.getdataSheetName("Sheet2", 0, 0);
		
		System.out.println(indexData);
		System.out.println(nameData);
		
	/**	WebDriver driver= null;
		List<String> browserList = DataProviderFactory.getConfiguration().getBrowsers();
		
		for (String browser : browserList) {
			driver = BrowserFactory.getBrowser(browser);
			Thread.sleep(5000);
			driver.get(DataProviderFactory.getConfiguration().getApplicationUrl());
			Thread.sleep(5000);
			BrowserFactory.colseWebDriver(driver);
		}*/
	}
}
