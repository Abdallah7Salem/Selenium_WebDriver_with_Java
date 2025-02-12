package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Xpath with single attribute
		//driver.findElement(By.xpath("//input[@placeholder = 'Search store']")).sendKeys("T-shirts");
		
		//Xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@name = 'q'][@placeholder = 'Search store']")).sendKeys("T-shirts");
		
		//Xpath with 'and' operator
		//driver.findElement(By.xpath("//input[@name = 'q' and @placeholder = 'Search store']")).sendKeys("T-shirts");
		
		//Xpath with 'or' operator
		//driver.findElement(By.xpath("//input[@name = 'q' or @placeholder = 'Search store']")).sendKeys("T-shirts");
		
		//Xpath with inner text - text()
		//driver.findElement(By.xpath("//*[text() = ' Electronics ']")).click();
		//Capture the display status and display it in the console
		//boolean displayStatus = driver.findElement(By.xpath("//strong[text() = 'Featured products']")).isDisplayed();
		//System.out.println(displayStatus);
		//Capture the text value of the element and display it
		//String textValue = driver.findElement(By.xpath("//strong[text() = 'Featured products']")).getText();
		//System.out.println(textValue);
		
		//Xpath with contains()
		//driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]")).sendKeys("T-shirts");
		
		//Xpath with starts-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("T-shirts");
	
		
		
		
	}

}
