package baseutils;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CommonLib {
	
	int milliseconds;
	ExtentTest test;
	WebDriver driver;
	public CommonLib(WebDriver driver,int milliseconds, ExtentTest test){
		this.driver=driver;
		this.milliseconds=milliseconds;
		this.test=test;
	}
	
	public void smartSleep() {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click(WebElement element,String webelementName) {
		Reports.info("Click on "+webelementName, test);
		element.click();
		smartSleep();
	}
	
	public void sendKeys(WebElement element,String webelementName,String value) {
		Reports.info("Provide value to "+webelementName, test);
		element.clear();
		element.sendKeys(value);
		smartSleep();
	}
	
	public void selectDropdown(WebElement dropdown, List<WebElement> dropdownList, String valueToSelect, String webelementName) {
		click(dropdown,webelementName);
		
		for(int i=0;i<dropdownList.size();i++) {
			String actual=dropdownList.get(i).getText();
			if(valueToSelect.equals(actual)) {
				click(dropdownList.get(i),valueToSelect);
				smartSleep();
				break;
			}
		}
	}
	
	public void verifyText(String expected, String actual) {
		if(expected.equals(actual)) {
			Reporter.log("Expected text is available--->PASS");
			test.pass("Expected text is available");
			test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
			
		}else {
			Reporter.log("Expected text is not available--->FAIL");
			test.fail("Expected text is not available");
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
			
		}
		
	}

}
