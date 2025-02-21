package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutomationPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class = 'wikipedia-search-button']")).click();
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id = 'wikipedia-search-result-link']/a"));
		
		// Click on each link using for loop
		for (WebElement searchResult : searchResults)
		{
			searchResult.click();
		}
		
		// Get window ID's for every browser window
		Set<String> windowsIDs_set = driver.getWindowHandles();
		
		// Close specific browser window
		for (String windowID : windowsIDs_set)
		{
			String title = driver.switchTo().window(windowID).getTitle();
			System.out.println(title);
			
			if (title.equals("Selenium disulfide - Wikipedia") || title.equals("Selenium dioxide - Wikipedia"))
			{
				driver.close();
			}
		}
		
		
	}

}
