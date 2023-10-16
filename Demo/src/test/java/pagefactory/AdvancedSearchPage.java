package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
	
	public AdvancedSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='fts' and @placeholder='Enter Job Keywords']")
	private WebElement keySkills_editbox;
	
	public WebElement keySkills_editbox() {
		return keySkills_editbox;
	}
	
	@FindBy(xpath="//*[@id='adv_home_autocomplete_location']")
	private WebElement location_editbox;
	
	public WebElement location_editbox() {
		return location_editbox;
	}
	
	@FindBy(xpath="//div[contains(@class,'exp-year-dd')]")
	private WebElement experience_years_dropdown;
	
	public WebElement experience_years_dropdown() {
		return experience_years_dropdown;
	}
	
	@FindBy(xpath="//div[contains(@class,'exp-month-dd')]")
	private WebElement experience_month_dropdown;
	
	public WebElement experience_month_dropdown() {
		return experience_month_dropdown;
	}
	
	@FindBy(xpath="//div[contains(@class,'salary-dd')]")
	private WebElement salary_dropdown;
	
	public WebElement salary_dropdown() {
		return salary_dropdown;
	}
	
	@FindBy(xpath="//label[text()='Industry']/following-sibling::div")
	private WebElement industry_dropdown;
	
	public WebElement industry_dropdown() {
		return industry_dropdown;
	}
	
	@FindBy(xpath="//label[text()='Function']/following-sibling::div")
	private WebElement function_dropdown;
	
	public WebElement function_dropdown() {
		return function_dropdown;
	}
	
	//input[@value='Show Jobs']
	
	@FindBy(xpath="//input[@value='Show Jobs']")
	private WebElement showJobs_button;
	
	public WebElement showJobs_button() {
		return showJobs_button;
	}
	


}
