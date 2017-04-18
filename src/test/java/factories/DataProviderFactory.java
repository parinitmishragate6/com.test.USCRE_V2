package factories;

import java.io.IOException;

import dataProvider.ConfigurationDataProvider;
import dataProvider.MiscTestDataExcel;
import dataProvider.TestDataProviderExcel;

/*
 * The purpose of this Class is to
 * -> Create Run Configuration Reader
 * -> Maintain an instance of the Reader so that single reader can be used across Tests or Framework
 * 
 */

public class DataProviderFactory {
	
	public static ConfigurationDataProvider getConfiguration() {
		ConfigurationDataProvider configuration = new ConfigurationDataProvider();
		return configuration;
	}
		
	//For TestDataProviderExcel Class integrated from FrameworkSWD_V_03
	
	private static TestDataProviderExcel testdataProvider = null;
	private static String testDataFilePath = "ApplicationTestData\\TestData.xls";
	private static String missTestDataFilePath = "ApplicationTestData\\AppData.xlsx";
	private static int sheetIndex = 0;
	
	public static TestDataProviderExcel getTestDataProvider() {
		if (testdataProvider == null) {
			try {
				testdataProvider = new TestDataProviderExcel(testDataFilePath, sheetIndex);
			} catch (IOException e) {
				System.out.println("Not able to create Test data provider. Exception -> " + e.getMessage());
			}
		}
		return testdataProvider;
	}
	
	// For test data from excel file Randomly 
	
	public static MiscTestDataExcel getMiscTestData() {
		MiscTestDataExcel miscTestData = new MiscTestDataExcel(missTestDataFilePath);
		return miscTestData;
	}
}
