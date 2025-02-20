package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitCommand {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// Explicit Wait Declaration
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		// Usage of Explicit Wait
		WebElement usernameTextBox = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Username']")));
		usernameTextBox.sendKeys("Admin");
		
		// Usage of Explicit Wait
		WebElement passwordTextBox = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Password']")));
		passwordTextBox.sendKeys("admin123");
		
		WebElement loginButton = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space() = 'Login']")));
		loginButton.click();
	}

}
