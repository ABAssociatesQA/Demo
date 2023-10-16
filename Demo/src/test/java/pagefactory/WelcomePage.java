package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='adv-search-link']/a[normalize-space(text())='Advanced Search']")
	private WebElement advancedSearch_link;
	
	public WebElement advancedSearch_link() {
		return advancedSearch_link;
	}
	
	//p[@class='job-count']
	
	@FindBy(xpath="//p[@class='job-count']")
	private WebElement jobcount_visibleText;
	
	public WebElement jobcount_visibleText() {
		return jobcount_visibleText;
	}

}
