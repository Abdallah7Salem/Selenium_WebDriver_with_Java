package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test Case Steps
 * 1) Launch Chrome Browser
 * 2) Open URL https://demo.opencart.com/
 * 3) Validate title should be "Your Store"
 * 4) Close Browser
 */

public class MyFirstTestCase {
	
	public static void main(String[] args) {
		
		//1) Launch Chrome Browser 
		WebDriver driver = new ChromeDriver();
		
		//2) Open URL https://demo.opencart.com 
		driver.get("https://demo.opencart.com");
		
		//3) Validate title should be "Your Store"
		String actual_title = driver.getTitle();
		
		if(actual_title.equals("Your Store"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//4) Close the browser
		driver.close();
		
	}

}
