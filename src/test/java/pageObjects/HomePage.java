package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath ="//span[normalize-space()='My Account']") WebElement linkMyAccount;
	
	@FindBy(xpath ="//a[normalize-space()='Register']")WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement login;
	
	//Actions
	
	public void myAccount() {
		linkMyAccount.click();
		
	}
	public void register() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	}
	

