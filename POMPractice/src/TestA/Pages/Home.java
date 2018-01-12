package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home {

	WebDriver driver;
	
	By verifyusername = By.id("ctl00_lblUserName");
	
	public Home(WebDriver driver)
	{
		this.driver = driver;
	}
	public void getHomepageDashboardUsername()
	{
		String Dashboardname = driver.findElement(verifyusername).getText();
		System.out.println("The Dashboard Name is"+Dashboardname);
		//Home page verification
		Assert.assertEquals(Dashboardname, "Joe Heltibrand");
	}
}
	

