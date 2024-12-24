package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevenueCalculator {
	
	WebDriver driver ; 
	Actions actionClass;
	
	@FindBy(xpath = "//h4[contains(text(),'Medicare Eligible Patients')]")
	
	WebElement SliderContainer;
	
	@FindBy(css = ".MuiSlider-sizeMedium.css-16i48op")
	WebElement Slider;
	
	@FindBy(css = ".MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputSizeSmall.css-1o6z5ng")
	WebElement TextField;
	
//	@FindBy(css = ".MuiBox-root.css-1eynrej")
	@FindBy (xpath = "//input[@type ='checkbox']")
	List<WebElement> CPTBoxes;
	
	
	@FindBy(xpath = "//input[@value]")
	WebElement Sliderbar;
	
	
	
	//initializing your page factory 
	public RevenueCalculator(WebDriver driver) throws IOException {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}	
	
	//Actions
	public WebElement ScrollToContainer() {
		return SliderContainer ;
	}
	
	public WebElement getTextBox() {
		return TextField;
	}
	
	public String getSliderBarValue() {
		return Sliderbar.getAttribute("value");
		
	}
	public WebElement getSlider() {
		return Slider;
		}
	public List<WebElement> getCheckBoxes() {
		return CPTBoxes;
	}
	
	
	

}
