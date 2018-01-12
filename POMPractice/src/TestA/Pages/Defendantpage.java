/**
 * 
 */
package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Test.common;

/**
 * @author pct150
 *
 */
public class Defendantpage {

	WebDriver driver;
	static By PersonType = By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnPersonType']");
	//static By Person_Type_list = By.xpath(".//td[@class='pad5 hideOverflow']/tr[1]/input");

	// Constructor
	public Defendantpage(WebDriver driver) {
		this.driver = driver;
	}

	// Person Type selection and verification
	/*public static void Person_Type() throws Exception {
		
			// boolean btn_persontype =
			// driver.findElement(PersonType).isEnabled();
		
		

			Thread.sleep(3000);
			System.out.println("aaaaaaaaa");
			WebElement btn_persontype = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnPersonType']"));
			System.out.println("vvvvvvvvvvvvvvvvv");
			if (btn_persontype.isEnabled()) {
				btn_persontype.click();
				
				Thread.sleep(3000);
				
				List<WebElement> asd = driver.findElements(By.xpath(".//table[@id='personTypeTable']//input"));
				System.out.println(asd.size());
				int count1 = 0;
				for (int i = 0; i < asd.size(); i++) {
					String dfg = asd.get(i).getAttribute("value");

					if (dfg == "Y") {
						count1++;
						System.out.println("Count is " + count1);
					} else {
						WebElement persontype_txt = driver.findElement(Person_Type_list);
						persontype_txt.click();
						persontype_txt.getText();
					}
				}
			} else {
				System.out.println("Person Type Button is not Enabled");
			}*/

			/*
			 * if(btn_persontype == true) {
			 * driver.findElement(PersonType).click(); }else {
			 * System.out.println("Person Type Button is not Enabled"); }
			 */

			// Get all the added rows
			/*List<WebElement> asd = driver.findElements(By.xpath(".//table[@id='personTypeTable']//input"));
			System.out.println(asd.size());
			int count1 = 0;
			for (int i = 0; i < asd.size(); i++) {
				String dfg = asd.get(i).getAttribute("value");

				if (dfg == "Y") {
					count1++;
					System.out.println("Count is " + count1);
				} else {
					WebElement persontype_txt = driver.findElement(Person_Type_list);
					persontype_txt.click();
					persontype_txt.getText();
				}
			}

		
	}*/
	
	public  void Person_Type() throws Exception{
		try {
			System.out.println("aaaaaaaaa");
			WebElement personTypeButton = driver.findElement(PersonType);
			System.out.println("aaaaaaaaa");
			if (personTypeButton.isEnabled()) {
				personTypeButton.click();
			}
			else{
				System.out.println("Driver Not clicked on Button");
			}
			}catch(Exception e){
				//TODO list
			}
			
		
			Thread.sleep(3000);
				//List<WebElement> asd = driver.findElements(By.xpath(".//table[@id='personTypeTable']//input"));
				List<WebElement> asd = driver.findElements(By.xpath(".//table[@id='personTypeTable']//tr"));
				System.out.println(asd.size());
				
				/*Thread.sleep(3000);
				int count1 = 0;
				for (int i = 0; i < asd.size(); i++) {
					String dfg = asd.get(i).findElement(By.tagName("TD")).getAttribute("value");

					if (dfg == "Y") {
						count1++;
						//System.out.println("Count is " + count1);
					} else {
						System.out.println("No checkbox selected");
					}
					System.out.println("Count is " + count1);
				}*/
				try{
						WebElement Search = driver.findElement(By.xpath(".//*[@id='personTypeTable_filter']/label/input"));
						Search.sendKeys("Gang");
						WebElement checkbox = driver.findElement(By.xpath(".//*[@id='0']/td[1]/input"));
						checkbox.click();
						checkbox.getText();
						if(checkbox.isSelected()){
							WebElement Accept_btn = driver.findElement(By.id("btnAdd"));
							Accept_btn.click();	
							driver.findElement(By.id("exitPersonType")).click();
							Thread.sleep(3000);
							//verify the text of button color using class because class is changing while adding information
							WebElement persontype = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnPersonType']"));
							persontype.getClass();
							System.out.println(persontype);
							AssertJUnit.assertEquals("btn btn-enabled information-Available", persontype);
							//verify selected text
							WebElement Reporttype = driver.findElement(By.id("ctl00_ContentPlaceHolderTitleRight_lblCaseReportingType"));
							Reporttype.getText();
							AssertJUnit.assertEquals(Reporttype, "Gang Member");
						}else{
							System.out.println("Checkbox is not checked");
						}						
						
				}catch(Exception e){
					//TODO
					}
				}
	
	public void Contactinfo_btn() throws Exception {
		try {
		//Contact info click
		WebElement Contact_btn_click = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnContactInfo"));
		Contact_btn_click.click();
		//verify record added or not
		WebElement verify_Entries = driver.findElement(By.xpath(".//*[@id='addressPopTable']//tbody/tr"));
		verify_Entries.getClass();
		System.out.println(verify_Entries);
		//Click on Add button
		WebElement Address_Add_btn = driver.findElement(By.id("btnAddAddress"));
		Address_Add_btn.click();
		WebElement Address_Desc = driver.findElement(By.id("txtAddressTypeDesc"));
		Address_Desc.sendKeys("P.O. Box 94608, Lincoln, NE 68509-4608 ");
		Address_Desc.sendKeys(Keys.TAB);
		WebElement Addres_add = driver.findElement(By.id("txtContactAddress1"));
		Addres_add.sendKeys("State Capitol, 1445 K St., Suite 2300, Lincoln, NE 68508");
		Addres_add.sendKeys(Keys.TAB);
		WebElement zip = driver.findElement(By.id("txtContactZip"));
		zip.sendKeys("68508");
		boolean verifystate = driver.findElement(By.id("txtContactState")).isDisplayed();
		boolean verifycity = driver.findElement(By.id("txtContactCity")).isDisplayed();
			if(verifystate == true && verifycity == true)
			{
			System.out.println("State & City both are displayed");
			}
			else{
			System.out.println("State & City both are not displayed");
			}
		//click on Add button
			boolean Address_Delete = driver.findElement(By.id("btnContactDelete")).isEnabled();
			boolean Address_Add = driver.findElement(By.id("btncontactSave")).isEnabled();
			
			if(Address_Delete == false && Address_Add == true) {
				WebElement Add_btn = driver.findElement(By.id("btncontactSave"));
				Add_btn.click();
			}
			//Verify record added or not
		}catch(Exception e) {
			//TODO
		}
		
		
	}
	
	
	
			
}
