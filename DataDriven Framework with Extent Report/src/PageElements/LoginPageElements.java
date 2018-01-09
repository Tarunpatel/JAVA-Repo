package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageElements {
	
	private static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {
		element = new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserName")));

		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {
		element = new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));

		return element;
	}

	public static WebElement btn_Login(WebDriver driver) {
		element = new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSubmit")));

		return element;
	}
	
	public static WebElement txt_LogedUser(WebDriver driver) {
		element = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@class='user-name']")));

		return element;
	}
	
	
}
