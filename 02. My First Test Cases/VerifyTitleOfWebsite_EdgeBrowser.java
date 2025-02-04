package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * Test Case Steps
 * 1) Launch Edge Browser
 * 2) Open URL https://demo.nopcommerce.com/
 * 3) Validate title should be "nopCommerce demo store"
 * 4) Close Browser
 */

public class VerifyTitleOfWebsite_EdgeBrowser {
	
	public static void main(String[] args) {
		
		//1) Launch Edge Browser 
		WebDriver driver = new EdgeDriver();
		
		//2) Open URL https://demo.opencart.com 
		driver.get("https://demo.nopcommerce.com");
		
		//3) Validate title should be "Your Store"
		String actual_title = driver.getTitle();
		
		if(actual_title.equals("nopCommerce demo store"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//4) Close the browser
		driver.quit();
		
	}

}
