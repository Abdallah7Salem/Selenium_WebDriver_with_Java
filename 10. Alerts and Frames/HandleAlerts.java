package day30;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// 1) Normal alert with OK button
		
		// open the alert box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		// switch to the alert window
		//Alert myAlert = driver.switchTo().alert();
		
		// close the alert window
		//myAlert.accept();
		
		// switch to the alert window and close it in a single line
		driver.switchTo().alert().accept();
		
		
		// 2) Confirmation Alert - OK & Cancel
		
		// open the alert box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		// close alert window using OK button
		driver.switchTo().alert().accept();
		
		// close alert window using Cancel button
		//driver.switchTo().alert().dismiss();
		
		
		// 3) Prompt alert - input box
		
		// open the alert window
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert myPromptAlert = driver.switchTo().alert();
		
		System.out.println("Alert Text Message: " + myPromptAlert.getText());
		
		// Pass text to the prompt alert
		myPromptAlert.sendKeys("Abdallah");
		myPromptAlert.accept();
		
		// Capture the text in the result
		String resultText = driver.findElement(By.xpath("//p[@id = 'result']")).getText();
		
		if (resultText.contains("Abdallah"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
