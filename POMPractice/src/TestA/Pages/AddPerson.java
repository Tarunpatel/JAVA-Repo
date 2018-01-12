package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AddPerson<retrun> {
	
	WebDriver driver;
	By AddPersonbtnClick = By.id("btnAddDefendant");
	By JCN = By.id("tChildNumber");
	By Address = By.id("ctl00_ContentPlaceHolder1_tAddress1");
	By Zipcode = By.id("ctl00_ContentPlaceHolder1_tZip");
	By DOB = By.id("ctl00_ContentPlaceHolder1_tDob2");
	By Race = By.id("ctl00_ContentPlaceHolder1_tRaceDisplay");
	By Hair = By.xpath("/html/body/form/div[3]/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div/input[1]");
	By Eye = By.xpath("/html/body/form/div[3]/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div/input[1]");
	By SSN = By.xpath("/html/body/form/div[3]/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/input");
	By AddPersonbtn = By.xpath("/html/body/form/div[3]/div/div[2]/div[1]/div[2]/div[3]/div/div[2]/div[3]/input[2]");
	By Updatepersonbtn = By.id("ctl00_ContentPlaceHolder1_saveDefendant");
	
	//Create Constructor
	public AddPerson(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Verify and Enter JCN Number.
	public void JCN_Entry(){
		boolean ActiveJCN = driver.findElement(JCN).isEnabled();
		if(ActiveJCN == true)
		{
			driver.findElement(JCN).sendKeys("MR");
		}
		else
		{
			System.out.println("ActiveJCN field is not displayed");
		}
		}
	//Verify and Enter Address method
	public void Address_Entry(){
		boolean Activeaddress = driver.findElement(Address).isEnabled();
		if(Activeaddress == true)
		{
			driver.findElement(Address).sendKeys("Cecilia Chapman 711-2880Nulla St.Mankato Mississippi");
		}
	}
	//Enter and verify zip code method 	
	public void verify_zipcode(){
		driver.findElement(Zipcode).sendKeys("85236");
		boolean verifystate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_tState")).isDisplayed();
		boolean verifycity = driver.findElement(By.id("ctl00_ContentPlaceHolder1_tCity")).isDisplayed();
		if(verifystate == true && verifycity == true)
		{
			System.out.println("State & City both are displayed");
		}
		else{
			System.out.println("State & City both are not displayed");
		}
	}
	//Select and verify age method
	public void DOBEntry() throws Exception{
		WebElement DOB = driver.findElement(By.id("ctl00_ContentPlaceHolder1_tDob2"));
		DOB.sendKeys("01-01-1971");
		DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		String verifydob = driver.findElement(By.id("ctl00_ContentPlaceHolder1_tAge")).getText();
		if(verifydob == "47")
		{
			System.out.println("DOB is displayed");
		}
		else
		{
			System.out.println("DOB is not displayed");
		}
		try{
		      driver.switchTo().alert().accept();
		}catch(Exception e){
		System.out.println("No Alert Found");
		}
	}
	//Select Race Method
	public void selectRace() throws Exception{
		WebElement mySelectElementRace = driver.findElement(Race);
		mySelectElementRace.sendKeys("As");
		Thread.sleep(2000);
		mySelectElementRace.sendKeys(Keys.ARROW_DOWN);
		mySelectElementRace.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("Race selected");
		}
	//Select Hair Method
	public void selecthair() throws Exception{
		WebElement mySelectElmentHair = driver.findElement(Hair);
		mySelectElmentHair.sendKeys("Bla");
		Thread.sleep(2000);
		mySelectElmentHair.sendKeys(Keys.ARROW_DOWN);
		mySelectElmentHair.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("Hair Selected");
	}
	//Select Eye method
	public void selecteye() throws Exception{
		WebElement mySelectElmentHair = driver.findElement(Eye);
		mySelectElmentHair.sendKeys("BK");
		Thread.sleep(2000);
		mySelectElmentHair.sendKeys(Keys.ARROW_DOWN);
		mySelectElmentHair.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("Eye Selected");
	}
	//Enter SSN number method
	public void EnterSSN() throws Exception{
		boolean SSN1 = driver.findElement(SSN).isDisplayed();
		if (SSN1 == true)
		{
			driver.findElement(SSN).sendKeys("122-12-1212");
		}
		else{
			System.out.println("SSN not Entered");
		}
	}
	//Click on Add Person(Defendant) button
	public void ClickonAddPerson() throws Exception
	{
		boolean AddPerson = driver.findElement(AddPersonbtn).isEnabled();
		if(AddPerson == true)
		{
			driver.findElement(AddPersonbtn).click();
		}else{
			System.out.println("Driver is not Enabedl");
		}
		try{
		      driver.switchTo().alert().accept();
		}catch(Exception e){
		System.out.println("No Alert Found");
		}
	}
		//Verify method for Add Person
		public void verify_test_AddPerson() throws Exception
		{
			boolean Updatetestaddperson = driver.findElement(Updatepersonbtn).isDisplayed();
			if(Updatetestaddperson == true)
			{
				System.out.println("Add Test cases Passed");
			}
			else{
				System.out.println("Add Test Cases Not Passed");
			}
	
		}
	

	
	
	
}
	


