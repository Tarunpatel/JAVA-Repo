package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	By Username = By.id("txtUserID");
	By Password = By.id("txtPassword");
	By btnLogin = By.name("btnLogin");
	
	public Login(WebDriver driver){
		this.driver = driver;
			}
	
	//set Username and password
	public void login(String username,String password){
		driver.findElement(Username).sendKeys("Joeh1");
		driver.findElement(Password).sendKeys("KCS");
	}
	//Click on Login Button
	public void clicklogin(){
		driver.findElement(btnLogin).click();
	}
	//Get page Title
	public String gettitle(){
		String title = driver.getTitle();
		return title;
	}
	
}
