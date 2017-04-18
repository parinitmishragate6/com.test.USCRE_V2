package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen_Uscre {

	public WebDriver driver;
	
	public HomeScreen_Uscre(WebDriver driver) {
		this.driver = driver;
	}
	
	// HomeUscre Screen title
	public String getApplicationTitle() {
		String appTitle = driver.getTitle();
		return appTitle;
	}
	
	// Elements & their Operations of Home Screen
	
	/**Start Home Screen */
	
	@FindBy(xpath="//button[@class='btn btn-grey']")
	WebElement signInButton1;
	
	public void clickSignIn1() {
		signInButton1.click();
	}
	
	
	@FindBy(xpath = "//*[@id='registerLink']")
	WebElement joinButton1;
	
	public void clickJoin1() {
		joinButton1.click();
	}
	
	/**End Home Screen */
	
	/**Start Login pop-up */
	
	@FindBy(xpath = "//*[@id='username']")
	WebElement userName;
	
	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	
	@FindBy(xpath = "//*[@id='password']")
	WebElement password;
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	@FindBy(xpath = "//label[text()='Remember Me ']")
	WebElement rememberMe;
	
	public void checkRememberMe() {
		if (!rememberMe.isSelected()) {
			rememberMe.click();
		}
	}
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement signInButton2;
	
	public void clickSignIn2() {
		signInButton2.click();
	}
	
	//Error message
	@FindBy(xpath = "//div[@id='errormessage']")
	WebElement errorMsg;
	public boolean errorMsg() {
		boolean status = errorMsg.isDisplayed();
		return status;
	}
	
	@FindBy(xpath = "(//span[@class='field-validation-error']/span[1])[1]")
	WebElement errorMsgUserName;
	public boolean errorMegUserName() {
		boolean status = errorMsgUserName.isDisplayed();
		return status;
	}
	
	@FindBy(xpath = "(//span[@class='field-validation-error']/span[1])[2]")
	WebElement errorMsgPassword;
	public boolean errorMegPassword() {
		boolean status = errorMsgUserName.isDisplayed();
		return status;
	}
	
	@FindBy(xpath = "//span[@class='field-validation-error']/span[1]")
	WebElement errorMsgBoth;
	public boolean errorMegBoth() {
		boolean status = errorMsgUserName.isDisplayed();
		return status;
	}
	
	/**End Login pop-up */	
	
}
