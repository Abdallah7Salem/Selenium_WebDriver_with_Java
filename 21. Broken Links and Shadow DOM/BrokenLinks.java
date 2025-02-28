package day39;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1) Link  href = "https://xyz.com"
 * 2) https://xyz.com --> server --> status code
 * 3) status code >= 400  --> broken link
 * 4) status code < 400   --> not a broken link
 */

public class BrokenLinks {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		
		int noOfBrokenLinks = 0;
		
		for (WebElement linkElement:links)
		{
			// getDomProperty() --> returns the value of the attribute passed
			String hrefAttributeValue = linkElement.getDomProperty("href");
			
			if (hrefAttributeValue == null || hrefAttributeValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty. So not possible to check");
				continue;
			}
			
			// Send request to the server
			try
			{
				// Convert the link from string to URL
				URL linkURL = new URL(hrefAttributeValue);
				// Open connection to the server
				HttpURLConnection connectionToServer = (HttpURLConnection)linkURL.openConnection();
				// Connect to server and send the request
				connectionToServer.connect();
				
				// Get status code
				if (connectionToServer.getResponseCode() >= 400)
				{
					System.out.println(hrefAttributeValue + "Broken link");
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(hrefAttributeValue + "Not a borken link");
				}
			}catch(Exception e)
			{
				
			}
			
			
		}
		
		System.out.println("Number of borken links: " + noOfBrokenLinks);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
