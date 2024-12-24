package TestPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Listners.ListnerClass;
import Pages.BrowserFactory;
import Pages.HomePage;
import Pages.RevenueCalculator;
import Utility.DriverUtils;
import Utility.LogsUtility;
import config.ConfigReader;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HomePageTest{
	ConfigReader c; 
	BrowserFactory b ;
	WebDriver driver ; 
	HomePage h ;
	Logger log;
	RevenueCalculator r;
	
	@BeforeSuite
	public void setup() throws IOException {
		driver = DriverUtils.getInstance();
	    h = new HomePage(driver);
	   // log =LogsUtility.getLogger(HomePageTest.class);// if listner created , then add this to listner class
	    BasicConfigurator.configure();
		
	}

	@Test(priority =1)
	public void VerifyNavigateionToHomePage() {
		String PageTitle = driver.getTitle();
		Assert.assertEquals(PageTitle,"Remote Patient Monitoring (RPM) - fitpeo.com" , "verified the navigation on home page" );
	//    log.info("Successful launch of the application"); // if listner created , then add this to listner classunder each method(i.e. on test failure) 
	    
	//	System.out.println("Successful launch of the application");
		
	}
	@Test(priority =2)
	public void VerifyNavigationOnRevenueCalculatorPage() throws InterruptedException, IOException {
		h.clickOnHeaderLink();
		Thread.sleep(6000);
		// add verification 
	}
	
	
	
	@AfterSuite
	public void tearDownDriver() {
		b.closeBrowser();
		
	}

}
