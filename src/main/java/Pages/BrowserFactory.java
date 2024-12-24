package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


	public class BrowserFactory {

	    private WebDriver driver;
		
	    public WebDriver getBrowserInstance(String browserName) {
	        // Using switch-case to handle multiple browser types
	        switch (browserName.toLowerCase()) {
	            case "chrome":
	                // Set ChromeDriver path if needed
	                System.setProperty("webdriver.chrome.driver.exe", "C:\\Users\\mittal.tannya\\eclipse-workspace1\\FitpeoAssignment\\src\\main\\java\\config\\config.properties");
	                driver = new ChromeDriver();
	                break;

	            case "firefox":
	                // Set GeckoDriver path if needed
	                System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
	                driver = new FirefoxDriver();
	                break;

	            case "edge":
	                // Set EdgeDriver path if needed
	                System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
	                driver = new EdgeDriver();
	                break;
	        }

	       
	        return driver;
	    }

	    // Method to close the browser and quit the WebDriver
	    public void closeBrowser() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



