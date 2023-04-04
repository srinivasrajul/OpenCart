package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDTT(String email, String password, String exp) {
		
		logger.info("*****Starting TC_002_LoginTest*****");
		try {
		HomePage hp =new HomePage(driver);
		hp.myAccount();
		logger.info("Clicked on login button in Home page");
		hp.clickLogin();
		
		logger.info("Entering login details");
		LoginPage lp= new LoginPage(driver);
		
		//previously we were providinfg data from property file 
		//but now we need to reed the data from excel sheet
		
		lp.setEmail(email);
		lp.setPassword(password);
		
		
		logger.info("Clicked on login");
		lp.ck();
		
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean mc=myacc.isMyAccExist();
		
		if(exp.equals("Valid")) {
			if(mc==true) {
			myacc.clickLogout();
			Assert.assertTrue(true);
			}
		
		else {
			Assert.assertTrue(false);
			
			}
		}
		if(exp.equals("Invalid")) {
			if(mc==false)
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			
		}
		}
		catch(Exception e) {
			Assert.fail();
			
			
		}
		
	}
	
	
	

}
