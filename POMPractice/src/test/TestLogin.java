package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Login;
import pages.Home;

public class Test {

	Login objLogin;
	Home objHome;
	
	WebDriver driver;
	
	//Create Object of an Class

	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Practice\\Resource\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		/*driver.navigate().to("https://stage.hostedbykarpel.com/PBK62");*/
		driver.navigate().to("https://stage.hostedbykarpel.com/PBK62");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	@Test
	public void test_Home_Page_Appear_Correct(){
		objLogin = new Login(driver);
	//verify Title
		String loginpageTitle = objLogin.gettitle();
		Assert.assertTrue(loginpageTitle.toLowerCase().contains("loginpageTitle"));
	//Login into application
		objLogin.login("JOEH","KCS");
		
		//Get next page
		objHome = new Home(driver);
		
		//verify Home page
		 Assert.assertTrue(objHome.getHomepageDashboardUsername().toLowerCase().contains("Joeh"));
	}
	
	
	
}
