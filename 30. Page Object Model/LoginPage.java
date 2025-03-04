package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By text_username_loc = By.xpath("//input[@placeholder = 'Username']");
	By text_password_loc = By.xpath("//input[@placeholder = 'Password']");
	By button_login_loc = By.xpath("//button[normalize-space() = 'Login']");

	// Action Methods

	public void setUserName(String userName) 
	{
		driver.findElement(text_username_loc).sendKeys(userName);
	}

	public void setPassword(String pwd) 
	{
		driver.findElement(text_password_loc).sendKeys(pwd);
	}

	public void clickLogin() 
	{
		driver.findElement(button_login_loc).click();
	}

}
