package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigurationDataProvider {
	
	Properties propertyFile;
	
	public ConfigurationDataProvider() {
		File source = new File("./Configuration/framework.properties");
		try {
			FileInputStream fis = new FileInputStream(source);
			propertyFile = new Properties();
			propertyFile.load(fis);
					
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	// Get Application Url
	public String getApplicationUrl() {
		String appUrl = propertyFile.getProperty("appUrl");
		return appUrl;
	}
	
	// To get Browsers
		public List<String> getBrowsers() {
			
			String browserName = propertyFile.getProperty("browserType");
			String[] browserArray = browserName.split(",");
			List<String> browserList = new ArrayList<String>();
			
			for(int i=0; i<browserArray.length; i++) {
				
				browserList.add(browserArray[i].trim());
				
			}
			
			return browserList;
			
		}
		
		// Wait Time
		
		public long getImplicitWaitTimeout() {
			
			String implicitWaitTimeout = propertyFile.getProperty("implicitWait");
			return Long.parseLong(implicitWaitTimeout);
			
		}
		
		public long getPageLoadTimeout() {
			
			String pageLoadTimeout = propertyFile.getProperty("pageLoadTimeout");
			return Long.parseLong(pageLoadTimeout);
			
		}
		
		public long getSleepTime() {
			
			String sleepTime = propertyFile.getProperty("sleepTime");
			return Long.parseLong(sleepTime);
			
		}
		
		/** Utilities */
		// Screen Shot On Failure
		public boolean getScreenShotOnFailure() {
			
			String screenShotOnFailure = propertyFile.getProperty("screenShotOnFailure");
			return Boolean.parseBoolean(screenShotOnFailure);
			
		}
		
		// Highlight Elements
		public boolean getHighlightElements() {
			
			String highlightElement = propertyFile.getProperty("highlightElement");
			return Boolean.parseBoolean(highlightElement);
			
		}
		
		/** Drivers */
		// Firefox Driver
		public String getFirefoxServerPath() {
			
			String firefoxServerPath = propertyFile.getProperty("FirefoxServerPath");
			return firefoxServerPath;
			
		}
		
		// IE Server Path
		public String getIEServerPath() {
			
			String iEServerPath = propertyFile.getProperty("IEServerPath");
			return iEServerPath;
			
		}
		
		// Chrome Server Path
		public String getChromeServerPath() {
			
			String chromeServerPath = propertyFile.getProperty("ChromeServerPath");
			return chromeServerPath;
			
		}
		
		// Get Run XMLs
		public List<String> getRunXmls() {
			String runXmls = propertyFile.getProperty("runXMLs");
			List<String> listOfRunXmls = new ArrayList<String>();
			
			for (String runXml : runXmls.split(",")) {
				listOfRunXmls.add(runXml.trim());
			}
			return listOfRunXmls;
		}
}
