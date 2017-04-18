package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCREScreen_Uscre {

	WebDriver driver;
	
	public MyCREScreen_Uscre(WebDriver driver) {
		this.driver = driver;
	}
	
	// MyCre Screen title
	public String getApplicationTitle() {
		String appTitle = driver.getTitle();
		return appTitle;
	}
	
	// MyCre Screen Elements
	
	@FindBy(xpath="//span[@class='name']")
	WebElement loggedinUserName;
	
	@FindBy(xpath=".//form[@id='logoutForm']//a[text()='Log Out']")
	WebElement logout;
	
	
	// Operation
	
	//loggedinUserName
	public boolean loggedinUserNameDisplayed() {
		return loggedinUserName.isDisplayed();
	}
	
	public boolean loggedinUserNameEnable() {
		return loggedinUserName.isEnabled();
	}
	
	public void clickLoggedinUserName() {
		loggedinUserName.click();
	}
	
	public String loggedinAsUser() {
		return loggedinUserName.getText();
	}
	
	// Logout
	public boolean logoutDisplayed() {
		return logout.isDisplayed();
	}
	
	public boolean logoutEnable() {
		return logout.isEnabled();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
}
