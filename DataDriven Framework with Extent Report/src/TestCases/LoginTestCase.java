package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;
import PageEntity.LoginPageObject;
import Utilities.general;
import PageElements.LoginPageElements;

public class LoginTestCase extends general 
{
	

	public static void abcd(String sheetName) throws Exception {
		
		//driver = general.drivers;
		List<String> errorMessages = new ArrayList<String>();
		String dispMessage = "";
		
		LoginPageObject lgnpgEnty = new LoginPageObject(sheetName);
		
		//driver = general.drivers;
		try {
			general.extentTest = general.extent.startTest("checkPage", "Verify url Brings user to the expected Page");

			// Navigate to url
			general.drivers.navigate().to(lgnpgEnty.getUrl());
			System.out.println(lgnpgEnty.getUrl());

			String pageTitle = general.drivers.getTitle();
			System.out.println(lgnpgEnty.getTitle());

			if (pageTitle.equalsIgnoreCase(lgnpgEnty.getTitle())) {
				System.out.println("Url brings user to the expected page");
				general.extentTest.log(LogStatus.INFO, "Url brings user to the expected page");
			} else {
				System.out.println("Fail");
				// general.extentTest.log(LogStatus.FAIL, "Wrong Page");
				errorMessages.add("Wrong Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (errorMessages.size() > 0) {
			for (String msg : errorMessages) {
				dispMessage = dispMessage + msg + "\n";
			}
		}
		AssertJUnit.assertTrue(dispMessage, dispMessage == "");

	}

	public static void def(String sheetName) {
		List<String> errorMessages = new ArrayList<String>();
		String dispMessage = "";
		
		LoginPageObject lgnpgEnty = new LoginPageObject(sheetName);

		// Enter Username
		LoginPageElements.txtbx_UserName(general.drivers).sendKeys(lgnpgEnty.getUserName());

		// Enter Password
		LoginPageElements.txtbx_Password(general.drivers).sendKeys(lgnpgEnty.getPassword());

		// Click on Login Button
		LoginPageElements.btn_Login(general.drivers).click();

		try {
			general.extentTest = general.extent.startTest("Verify Login ", "Verify user is able to login");

			String displayedUser = LoginPageElements.txt_LogedUser(general.drivers).getText().toUpperCase();
			System.out.println(displayedUser);

			String expectedUser = lgnpgEnty.getExptLoggedUser().toUpperCase();
			if (displayedUser.equals(expectedUser)) {
				general.extentTest.log(LogStatus.INFO,
						"Pass : Login Functionality -> And Logged in user is:- " + displayedUser);
				System.out.println("Pass : Login Functionality -> And Logged in user is:- " + displayedUser);
			} else {
				errorMessages.add("Fail : Login Functionality -> Should display user name as :- " + expectedUser
						+ " page url:- " + general.drivers.getCurrentUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (errorMessages.size() > 0) {
			for (String msg : errorMessages) {
				dispMessage = dispMessage + msg + "\n";
			}
		}
		AssertJUnit.assertTrue(dispMessage, dispMessage == "");
	}

}
