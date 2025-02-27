package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// 1) Scroll down the page by pixel number
//		js.executeScript("window.scrollBy(0, 1000)", "");
//		System.out.println(js.executeScript("return window.pageYOffset;"));

		
		// 2) Scroll down the page till element is visible
//		WebElement element = driver.findElement(By.xpath("//strong[normalize-space() = 'Community poll']"));
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		System.out.println(js.executeScript("return window.pageYOffset;"));

		
		// 3) Scroll down till end of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.err.println(js.executeScript("return window.pageYOffset;"));
		
		// Scroll up to the initial position
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
