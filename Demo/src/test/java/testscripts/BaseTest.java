package testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseutils.Browser;
import baseutils.CommonLib;
import baseutils.Reports;
import pagefactory.AdvancedSearchPage;
import pagefactory.WelcomePage;
import testdata.Constants;

public class BaseTest {
	
	
	WebDriver driver;
	CommonLib commonLibObj;
	Browser browserObj;
	
	
	ExtentSparkReporter esr;
	ExtentReports extent;
	ExtentTest test;
	
	WelcomePage welcomePageObj;
	AdvancedSearchPage advancedSearchPageObj;
	
	@BeforeTest
	public void beforetest() {
		esr=new ExtentSparkReporter("target/ExecutionReport.html");
		extent=new ExtentReports();
		extent.attachReporter(esr);
	}
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	@BeforeMethod
	public void beforeMthod(Method method) {
		test=extent.createTest(method.getName());
		browserObj=new Browser();
		driver=browserObj.getBrowser(Constants.browserName, Constants.driverPath);
		
		Reports.info("Navigate to url:"+Constants.url, test);
		driver.get(Constants.url);
		
		commonLibObj=new CommonLib(driver,Constants.milliseconds, test);
		welcomePageObj=new WelcomePage(driver);
		advancedSearchPageObj=new AdvancedSearchPage(driver);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	

}
