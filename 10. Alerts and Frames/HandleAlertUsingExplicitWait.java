package day30;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// Explicit wait declaration
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// Open alert box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		// Capture the alert box using explicit wait
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
		
		myAlert.accept();
		
		
		
		
		
		
		
		
		
		
		

	}

}
