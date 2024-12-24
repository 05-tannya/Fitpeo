package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver ; 
	
    //Locators
	@FindBy(linkText = "Revenue Calculator")
	WebElement calulatorLink;
	
	//initializing your page factory 
		public HomePage(WebDriver driver) throws IOException {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	//Actions

	public RevenueCalculator clickOnHeaderLink() throws IOException {
		calulatorLink.click();
		return new RevenueCalculator(driver);
		
	}
}
