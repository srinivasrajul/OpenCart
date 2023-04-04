package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators 
	
	@FindBy(name = "firstname") WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement confirm;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement continue1;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmation;
	
	
	
	//Actions
	
	public void fname(String fname) {
		firstName.sendKeys(fname);
	}
	public void lname(String lname) {
		lastName.sendKeys(lname);
	}
	public void email(String email1) {
		email.sendKeys(email1);
		
	}
	public void tele(String ph) {
		telephone.sendKeys(ph);
		
	}
	public void pw(String pass) {
		password.sendKeys(pass);
		
	}
	public void conpw(String cpass) {
		confirmPassword.sendKeys(cpass);
		
	}
	public void con() {
		confirm.click();
		
	}
	
	public void conti() {
		continue1.click();
		
	}
	
	public String getconfirmationMsg() {
		try {
			return (confirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	
	}

}
