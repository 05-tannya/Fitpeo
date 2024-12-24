package TestPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.RevenueCalculator;
import Utility.ActionsUtility;

public class RevenueCalculatorPageTest extends HomePageTest {
	public ActionsUtility a ; 
	public RevenueCalculator r;
	
    @BeforeMethod
    public void initilizeUtilities() throws IOException {
    	a= new ActionsUtility();
    	r= new RevenueCalculator(driver);
    }
	@Test(priority =1)
	public void VerifyScrollToBottom() throws InterruptedException {
	//WebElement w = r.ScrollToSlider();
	//	By locator = By.cssSelector(".MuiBox-root.css-j7qwjs");
	double  page_height =a.ScrollToBottom();
	System.out.println("height of the page is" + " "+  page_height);
	}
	
	@Test(priority =2)
	public void VerifyScrollToSpecificSection() {
	WebElement wb 	=r.ScrollToContainer();
	a.ScrollDownToView(wb);
	System.out.println("successful scrolling to a specific section of a window ");
	}
	
	@Test(priority = 3)
	public void VerifySliderMovement() throws InterruptedException, IOException {
		a.SliderMovementThroughActions(r.getSlider());
		Thread.sleep(3000);
		String sliderBarValue =r.getSliderBarValue();
		System.out.println("UPDATED SLIDER VALUE" + sliderBarValue);
		Assert.assertEquals(sliderBarValue, "1662");		
		
	}
    @Test(priority =4)
	public void VerifyTextBoxDataUsingActionsClass() {
    	 WebElement  TextBoxElement = r.getTextBox();
    	 a.AddValueToTextBox(TextBoxElement);
    	 String sliderBarUpdated=r.getSliderBarValue();
    	 Assert.assertEquals(sliderBarUpdated, "520");
		
	}
    
    @Test(priority = 5)
    public void VerifyTheChcekboxSElection() throws InterruptedException {
    	List<WebElement> chcekBoxes = r.getCheckBoxes();
    	for(WebElement eachCheckBox :chcekBoxes ) {
    		a.ScrollDownToView(eachCheckBox);
    		System.out.println("CHECKBOX ELEMENT" + eachCheckBox);
    		Thread.sleep(1000);
    		if(eachCheckBox.isDisplayed() && eachCheckBox.isEnabled()) {
    	      //a.ActionsClick(eachCheckBox);
    		  a.JsClick(eachCheckBox);
    		  Assert.assertTrue(eachCheckBox.isSelected(), "The checkbox is  not selected");
    		  System.out.println("CHCEKBOX WORKING");
    		}
    		else {
    		System.out.println("CHECKBOX IS NOT DISPLAYED AND ENABLED ");
    		}
    		
    	}
  
    }
}
