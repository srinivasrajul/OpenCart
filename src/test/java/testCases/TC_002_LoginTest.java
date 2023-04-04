package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
//import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		try {
		
		logger.info("*****Starting TC_002_LoginTest*****");
		HomePage hp =new HomePage(driver);
		hp.myAccount();
		logger.info("Clicked on login button in Home page");
		hp.clickLogin();
		
		logger.info("Entering login details");
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		logger.info("Clicked on login");
		lp.ck();
		
		logger.info("Sucessfully Logged in");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage= macc.isMyAccExist();
		Assert.assertEquals(targetPage, true,"login not sucessfulll");
		logger.info("Sucessfully Logged in");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC_002_LoginTest*****");
		
	}
	
	

}
