package day28;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// Get - accepts URL only in the string format
		//driver.get("https://demo.nopcommerce.com/");
		
		// URL myUrl = new URL("https://demo.nopcommerce.com/")
		// accepts the URL in two formats : string, URL object
		// converts the URL object internally into string format, then calls Get method		
		// driver.navigate().to(myUrl);

		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
				
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
	}

}
