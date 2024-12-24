package Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.RevenueCalculator;

public class ActionsUtility {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actionClass;
	RevenueCalculator r;
	
	public ActionsUtility(){
		try {
			driver = DriverUtils.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
		js  = (JavascriptExecutor) driver;
		}
		
		catch(Exception e){
			System.out.println("catch of js");
			e.printStackTrace();
		}
	}
	
	public void ScrollDownToView(WebElement targetElement ) {
		//System.out.println("TANNYA_DEBUGGING locator" + js); --- debugging 
		js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
	}
	
	/*public void SliderMovement(WebElement Slider) {

	    // Set the value of the slider
	    js.executeScript("arguments[0].value = arguments[1];", Slider, "100");

	    // Trigger the 'input' and 'change' events to simulate user interaction
	    js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", Slider);
	    js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", Slider);
	}*/

	public void AddValueToTextBox(WebElement TextBox ) {
		actionClass = new Actions(driver);
		TextBox.clear();
		actionClass.click(TextBox).sendKeys("100").perform();

	}
	public double ScrollToBottom() throws InterruptedException {
		//debug-- for element cast exception 
		Object pageHeightBefore = js.executeScript("return document.body.scrollHeight;");
		Double pageHeight = (pageHeightBefore instanceof Long) ? ((Long) pageHeightBefore).doubleValue() : (Double) pageHeightBefore;
		System.out.println("PAGE HEIGHT AT START" + " "+ pageHeight);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//debug-- chcek for the scroll position 
		Thread.sleep(3000);
		return pageHeight ;
		
	}
	public void SliderMovementThroughActions(WebElement Slider) throws IOException {
		actionClass = new Actions(driver);
		r = new RevenueCalculator(driver);
		
		int sliderWidthINpixcels = Slider.getSize().getWidth();
        System.out.println("SLIDER WIDTH" + sliderWidthINpixcels);
        double valueOfEachPixcel = 2000.0/sliderWidthINpixcels;
        System.out.println("VALUE OF EACH PIXCEL" + valueOfEachPixcel);
        
        // Fetch the current value of the slider dynamically
        int currentValue = Integer.parseInt(r.getSliderBarValue());
        System.out.println("Current Slider Value: " + currentValue);
        
        int offset = (int) ((820 - currentValue) / valueOfEachPixcel);
        System.out.println("OFFSET VALUE " + offset);
		actionClass.clickAndHold(Slider).moveByOffset(offset,0).release().perform();
		
	}
	public void ActionsClick(WebElement target) {
		actionClass = new Actions(driver);
		actionClass.click(target).release().perform();
	}
	
	public void JsClick(WebElement target) {
		System.out.println("DEBUGGING JS CLICK" + target);
		js.executeScript("arguments[0].click();", target);
		js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", target);
	}

}
