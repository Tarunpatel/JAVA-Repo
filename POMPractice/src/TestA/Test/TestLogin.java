package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Home;
import Pages.Login;
import Pages.Search;
import Pages.AddPerson;
import Pages.Defendantpage;
//import Pages.Defendantpage;

public class TestLogin {

	Login objLogin;
	Home objHome;
	Search objsearch;
	AddPerson objaddperson;
	Defendantpage objdefendant;
	//Defendantpage ovjdefendantpage;
	//WebDriver driver;
	//WebDriverWait wait;
	
	//Create Object of an Class

	@BeforeTest
	public void setup()
	{
		/*System.setProperty("webdriver.gecko.driver","D:\\Projects\\Practice\\Resource\\geckodriver.exe");*/
		System.setProperty("webdriver.chrome.driver","D:\\Projects\\Practice\\Resource\\chromedriver.exe");
		common.driver = new ChromeDriver();
		common.driver.manage().window().maximize();
		
		/*driver.navigate().to("https://stage.hostedbykarpel.com/PBK62");*/
		common.driver.navigate().to("https://stage.hostedbykarpel.com/PBK62");
	}

	@AfterTest
	public void teardown()
	{
		common.driver.quit();
	}
	@Test(priority=0)
	public void test_URL_Launch_Appear_Correct() throws Throwable{
		objLogin = new Login(common.driver);
	//verify Title
		//String loginpageTitle = objLogin.gettitle();
		System.out.println(objLogin.gettitle());
		//Assert.assertTrue(loginpageTitle.toLowerCase().contains("PROSECUTORbyKarpel"));
		Assert.assertEquals(objLogin.gettitle(), "PROSECUTORbyKarpel");
		//Login into Application
		objLogin.login("JOEH","KCS");
		objLogin.clicklogin();
		//driver.wait(3000);
		objHome = new Home(common.driver);
		//Verify Successful Login
		//driver.wait(50);
		objHome.getHomepageDashboardUsername();
	}
		@Test(priority=1)
			public void test_Search() throws Exception {
				objsearch = new Search(common.driver);
				Thread.sleep(2000);
				objsearch.searchparameter("Bogus", "B");
				objsearch.clickonsearch();
				objsearch.verifysearch();
				objsearch.clickonaddperson();
}
		@Test(priority=2)
		public void test_AddPerson() throws Exception{
			objaddperson =new AddPerson(common.driver);
			
			Thread.sleep(2000);
			objaddperson.JCN_Entry();
			objaddperson.Address_Entry();
			objaddperson.verify_zipcode();
			objaddperson.DOBEntry();
			objaddperson.selectRace();
			objaddperson.selecthair();
			objaddperson.selecteye();
			objaddperson.EnterSSN();
			objaddperson.ClickonAddPerson();		
		}
		@Test(priority=3)
		public void verify_Addperson() throws Exception{
			objaddperson.verify_test_AddPerson();
			}
		@Test(priority=4)
		public void verify_Defendant() throws Exception{
			//Defendantpage.Person_Type();
			objdefendant = new Defendantpage(common.driver);
			objdefendant.Person_Type();
			objdefendant.Contactinfo_btn();
		}
		}	
		
		
		
	
