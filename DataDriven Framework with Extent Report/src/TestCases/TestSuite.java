package TestCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.general;




public class TestSuite {
	//public static WebDriver driver;
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return destination;
	}
	
	@BeforeTest
	public void setUp() throws Exception {
		String confFilePath = System.getProperty("user.dir") + "\\extent-config.xml";
		general.extent.loadConfig(new File(confFilePath));
		/*System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Driver\\Chrome\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();*/
		
		general.OpenBrowser("Sheet1");
		
		System.out.println("aaaaaaaaa");
		
	}
	
	
	@Test(priority=1)
	public void VerifyPage() throws Exception{
		System.out.println("vvvvvvvvvvvv");
		//LoginTestCase.abcd("Sheet1");
		LoginTestCase.abcd("Sheet1");
	}
	
	@Test(priority=2)
	public void LoginFunctionality() throws Exception{
		//LoginTestCase.abcd("Sheet1");
		LoginTestCase.def("Sheet2");
	}


	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			general.extentTest.log(LogStatus.FAIL, "Module Name:- "+result.getName());
			general.extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                        //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 			
                        String screenshotPath = TestSuite.getScreenshot(general.drivers, result.getName());
			//To add it in the extent report 
                        
                        general.extentTest.log(LogStatus.FAIL, general.extentTest.addScreenCapture(screenshotPath));
			
                        //logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			general.extentTest.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		general.extent.endTest(general.extentTest);
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		//general.webdriver.get(System.getProperty("user.dir") + "\\extentReportFile.html");
		Thread.sleep(4000);
		general.drivers.get(System.getProperty("user.dir") + "\\extentReportFile.html");
		general.extentTest.log(LogStatus.INFO, "Browser Closed");
		general.extent.flush();
		general.drivers.navigate().refresh();
		//general.extent.close();
		
	}
	
	
	
	
}
