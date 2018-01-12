package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	WebDriver driver;
	
	By verifyusername = By.id("ctl00_lblUserName");
	
	public Home(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getHomepageDashboardUsername()
	{
		return driver.findElement(verifyusername).getText();
	}
	
}

