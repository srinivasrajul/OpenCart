package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Regression","Master","Sanity"})
	@Parameters("browser")
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		
		
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		// After selenium 4.6.0 WebdriverManager has been included in selenium client library
		// we don't need WebDriverManager to setup the driver
		WebDriverManager.chromedriver().setup(); //or system.setproperty....
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable notifications");
//		DesiredCapabilities cp = new DesiredCapabilities();
//		cp.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(cp);
		driver = new ChromeDriver(options);
		if(br.equals("chrome")) 
		{
			driver= new ChromeDriver(options);
		}
		else if(br.equals("edge"))
		{
			driver= new EdgeDriver();
			
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();

	}
	
	
	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown() {
		driver.quit();
		
	}
	
	
	public String randomString() {
		String generatedStr=RandomStringUtils.randomAlphabetic(5);
		return generatedStr;
		
	}
	
	public String randomNum() {
		String generatedStr1=RandomStringUtils.randomNumeric(10);
		return generatedStr1;
		
	}

	
	public String randomAlphaNumeric() {
		String str1=RandomStringUtils.randomAlphabetic(5);
		String str2=RandomStringUtils.randomAlphabetic(10);
		return str1+str2;
		
	}


	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}


}
