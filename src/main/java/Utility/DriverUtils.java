package Utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Pages.BrowserFactory;
import config.ConfigReader;

public class DriverUtils {
	

	public static WebDriver driver = null;
	
	public static WebDriver getInstance() throws IOException {
		if(driver == null) {

			ConfigReader c; 
			BrowserFactory b ;
			c = new ConfigReader();
			String browsername = c.RetriveProperty("Browser");
			System.out.println(browsername);
			String URL = c.RetriveProperty("Url");
			System.out.println(URL);
		    b= new BrowserFactory();
		    driver = b.getBrowserInstance(browsername);
		    driver.get(URL);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}
		return driver;
	}

}
