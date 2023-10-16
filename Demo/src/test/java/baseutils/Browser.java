package baseutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	WebDriver driver;
	
	public WebDriver getBrowser(String browserName, String driverPath) {
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", driverPath);
			driver=new InternetExplorerDriver();
		
		}
		return driver;
	}

}
