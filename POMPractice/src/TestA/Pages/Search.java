package Pages;

import static org.testng.Assert.assertEquals;

import java.io.EOFException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.NumberFormat;

public class Search {

	WebDriver driver;
	
	By LastName = By.id("ctl00_ContentPlaceHolder1_txtLastName");
	By FirstName = By.id("ctl00_ContentPlaceHolder1_txtFirstName");
	By btnsearchclick = By.id("btnPersonSearch");
	String lastname;
	String firstname;
	By AddPersonbtnClick = By.id("btnAddDefendant");

	private String Name;
		//Constructor for Search page
	public Search(WebDriver driver){
		this.driver = driver;
	}
	
	//First and Last Name Enter
	public void searchparameter(String lastname, String firstname){
		driver.findElement(LastName).sendKeys("Bogus");
		driver.findElement(FirstName).sendKeys("B");
	}
	
	public void clickonsearch(){
		driver.findElement(btnsearchclick).click();
	}
	
	public void verifysearch() throws Exception {
		/*List<WebElement> totalcol = driver.findElements(By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div[1]/div[1]"));
		System.out.println("Columns value is"+totalcol.size());
		List <WebElement> totalrow = driver.findElements(By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div[2]/table/tbody"));
		System.out.println("ROws Value is "+ totalrow.size());
					
		for(int row = 1;row<=totalrow.size();row++)
		{
				String Name = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div[2]/table/tbody/tr["+row+"]/td[2]")).getText();
				
				//If Name will match whatever entered by user
				if(Name.equals(lastname))
				{
					assertEquals("Verify Lastname", "lastname", Name);
				}
					}*/
		//Get Rows Count
		try{
			WebElement htmltable=driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div[1]/div[1]"));
		List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
		System.out.println("Rows Are"+ rows.size());
		//Get Column count
		for(int rnum=0;rnum<rows.size();rnum++)
		{
		List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));

		System.out.println("Number of columns:"+columns.size());
		//Get First text
			for(int cnum=0;cnum<columns.size();cnum++)
			{
				System.out.println(columns.get(cnum).getText());
			}
		}
			//Verify Logic of Grid
			for(int row = 1;row<=rows.size();row++)
			{
				String Name = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div[2]/table/tbody/tr["+row+"]/td[2]")).getText();
			}
			if(Name.contains("B")){
			System.out.println("All record matches");
		}else{
			System.out.println("Something Wrong in search");
		}
		}catch(Exception e){
			System.out.println("Not matched and Search Failed");
		}
	}
		//Click on Add Person after search record
	public void clickonaddperson() throws Exception{
		try{
		boolean CheckAddPersonbtn = driver.findElement(AddPersonbtnClick).isEnabled();
		if(CheckAddPersonbtn == true)
		{
			driver.findElement(AddPersonbtnClick).click();
		}
	}catch(Exception e){
		System.out.println("Driver not clicked");
	}
 }
}
