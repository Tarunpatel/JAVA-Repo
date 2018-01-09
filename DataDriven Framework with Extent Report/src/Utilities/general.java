package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageEntity.LoginPageObject;

public class general {
	public static WebDriver drivers;
	public static String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	// public static ExtentReports extent = new ExtentReports(extentReportFile);
	public static ExtentReports extent = new ExtentReports(extentReportFile);
	public static ExtentTest extentTest;

	

	public static void OpenBrowser(String sheetName) throws Exception {
		
		
		LoginPageObject lgnpgEnty = new LoginPageObject(sheetName);
		
		String browser = lgnpgEnty.getBrowser();// pro.getProperty("browser");
		if (browser.equals("FF")) {
			System.out.println(browser);
			// driver = new FirefoxDriver();
			// log.info("Start Test Using FireFox");
		} else if (browser.equals("IE")) {
			System.out.println(browser);
			// System.setProperty("webdriver.ie.driver",
			// pro.getProperty("IEDriverServer"));
			// driver = new InternetExplorerDriver();
			// log.info("Start Test Using Internet Explorer");
		} else if (browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Practice\\Resource\\chromedriver.exe");

			drivers = new ChromeDriver();

			drivers.manage().window().maximize();
			System.out.println(browser);
			// System.setProperty("webdriver.chrome.driver",
			// pro.getProperty("ChromeDriverServer"));
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--test-type");
			// driver = new ChromeDriver(options);
			// log.info("Start Test Using Chrome");

		} else {
			System.out.println("No Browser Found");
			// log.info("No Browser Found");
		}
		// ATUReports.setWebDriver(driver);

		//drivers= driver;
	}
	
	/*public static void main(String[] args) throws Exception {
		OpenBrowser("Sheet1", driver);
	}*/

	

}
