package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		// Open a new browser window
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		// Close one browser window
		//driver.close();
		
		// Close all browser windows
		driver.quit();
		
	}

}
