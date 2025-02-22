package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * 2) Hidden dropdown
Login to OrangeHRM--> pim--> employee status
 */


public class HiddenDropdown_Task {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");

		driver.manage().window().maximize();
		
		// Login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space() = 'Login']")).click();
		
		// Click on PIM
		driver.findElement(By.xpath("//span[normalize-space() = 'PIM']")).click();
		
		// Click the dropdown
		WebElement employmentStatus = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]"));
		employmentStatus.click();
		
		// Select a single option
		// To locate the hidden dropdown options
		// 1) use selectorhub debugger
		// or 2) delete blur from "event listeners" in dev tools
		driver.findElement(By.xpath("//span[normalize-space()='Full-Time Contract']")).click();
		
		
		
		
		
		
		
		
		
		
		

	}

}
