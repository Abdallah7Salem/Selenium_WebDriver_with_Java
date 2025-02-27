package day36;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement registerationLink = driver.findElement(By.xpath("//a[normalize-space() = 'Register']"));
		
		Actions act = new Actions(driver);
		
		// Ctrl + Click => to open the link in a new window
		act.keyDown(Keys.CONTROL).click(registerationLink).keyDown(Keys.CONTROL).perform();
		
		// Get all windows handles
		// Convert the Set into List
		List<String> windowsIDsList = new ArrayList<String>(driver.getWindowHandles());
		
		// Switch to the Registration Page Window
		driver.switchTo().window(windowsIDsList.get(1));
		
		// Enter the first name
		driver.findElement(By.xpath("//input[@id = 'FirstName']")).sendKeys("Abdallah Qandil");
		
		// Switch to Home Page
		driver.switchTo().window(windowsIDsList.get(0));
		
		// Enter T-Shirts in the search box
		driver.findElement(By.xpath("//input[@id = 'small-searchterms']")).sendKeys("TShirts");
		
		
		
		
		
		
		
		
		
		

	}

}
