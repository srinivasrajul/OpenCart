package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//input[@id='input-email']") WebElement emailAddress;

	@FindBy(xpath ="//input[@id='input-password']") WebElement password;
	
	@FindBy(xpath ="//input[@value='Login']") WebElement loginClick;
	
	public void setEmail(String ea) {
		emailAddress.sendKeys(ea);
	}
	public void setPassword(String pw) {
		password.sendKeys(pw);
	}

	public void ck() {
		loginClick.click();
	}


}
