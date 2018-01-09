package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithTestNGXML {
	WebDriver webdriver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Driver\\Chrome\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Parameters({"author","searchKey"})
	@Test
    public void testParameterWithXML( @Optional("Abc") String author,String searchKey) throws InterruptedException{
		
		 webdriver.get("https://google.com");

	        WebElement searchText = webdriver.findElement(By.name("q"));
	        //Searching text in google text box
	        searchText.sendKeys(searchKey);

	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	        System.out.println("Thread will sleep now");
	        Thread.sleep(3000);
	        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
	        //verifying the value in google search box
	        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}
}
