package day47;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	WebDriver driver;

	// Constructor
	LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	// Mandatory
	}

	// Locators
	
	//@FindBy(xpath = "//input[@placeholder = 'Username']") 
	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Username']")
	WebElement text_username;
	
	@FindBy(xpath = "//input[@placeholder = 'Password']") 
	WebElement text_password;
	
	@FindBy(xpath = "//button[normalize-space() = 'Login']")
	WebElement button_login;
	
	
	// Locate all the links
	@FindBy(tagName = "a")
	List<WebElement> links;
	
	
	// Action Methods

	public void setUserName(String userName) 
	{
		text_username.sendKeys(userName);
	}

	public void setPassword(String pwd) 
	{
		text_password.sendKeys(pwd);
	}

	public void clickLogin() 
	{
		button_login.click();
	}

}
