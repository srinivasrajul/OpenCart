package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	 void test_AccountRegistrationTest() throws InterruptedException {
		logger.debug("Application logs.....");
		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		try {
		HomePage hp= new HomePage(driver);
		hp.myAccount();
		logger.info("Clicked on My Account link");
	//	Thread.sleep(5000);
		hp.register();
		logger.info("Clicked on Register");
		//Thread.sleep(5000);
		
		
		AccountRegistrationPage ap= new AccountRegistrationPage(driver);
		logger.info("Registration page opened and registration details entering");
		ap.fname(randomString());
		ap.lname(randomString());
		ap.email(randomString()+"@gmail.com");
		ap.tele(randomNum());
		String genPw=randomString();
		ap.pw(genPw);
		ap.conpw(genPw);
		ap.con();
		ap.conti();
		logger.info("Registration details entered and clicked on continue");
		String confirmMsgs=ap.getconfirmationMsg();
		//Thread.sleep(3000);
		Assert.assertEquals(confirmMsgs, "Your Account Has Been Created!");
		logger.error("Test case Failed");
		Assert.fail();
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_001_AccountRegistrationTest ****");
		
	}

}
