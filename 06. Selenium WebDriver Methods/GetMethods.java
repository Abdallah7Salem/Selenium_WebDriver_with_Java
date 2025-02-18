package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		// get(url) - Open the URL on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		// getTitle() - Return the title of the page
		System.out.println(driver.getTitle());

		// getCurrentUrl() - Return URL of the page
		System.out.println(driver.getCurrentUrl());
		
		// getPageSource() - Return source code of the page
		System.out.println(driver.getPageSource());
		
		// getWindowHandle() - Returns ID of the single browser window
		String windowId = driver.getWindowHandle();
		System.out.println("Window ID: " + windowId);
		
		// getWindowHandles() - Returns IDs of multiple browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowsIds = driver.getWindowHandles();
		System.out.println(windowsIds);
		
		
		
	}

}
