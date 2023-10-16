package testscripts;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import baseutils.ReadExcelData;
import baseutils.Reports;

public class VerifyAdvanceSearchTest extends BaseTest{

	@DataProvider
	public String[][] searchDetails() {
		ReadExcelData re=new ReadExcelData();
		return re.readExcelData("../Demo/ExcelFiles/SearchDetails.xlsx", "Sheet1");
	}
	
	@Test(dataProvider="searchDetails")
	public void verifyAdvanceSearchTest(String keySkills, String location, String exp_years
			,String exp_months, String salary,String industry, String function) {
		
		commonLibObj.click(welcomePageObj.advancedSearch_link(), "advancedSearch_link");
		commonLibObj.sendKeys(advancedSearchPageObj.keySkills_editbox(), "keySkills_editbox", keySkills);
		commonLibObj.sendKeys(advancedSearchPageObj.location_editbox(), "location_editbox", location);
		commonLibObj.click(advancedSearchPageObj.showJobs_button(), "showJobs_button");
		
		String jobCount=welcomePageObj.jobcount_visibleText().getText();
		Reports.info("Job count is: "+jobCount, test);
		test.info(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
		
		
	}
}
