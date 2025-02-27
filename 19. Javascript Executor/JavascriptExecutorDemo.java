package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement inputBox = driver.findElement(By.xpath("//input[@id = 'name']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// JavascriptExecutor js = driver; => in case of ChromeDriver Object

		// Passing text into inputbox - alternate of sendKeys()
		js.executeScript("arguments[0].setAttribute('value', 'Abdallah')", inputBox);
		
		// Perform click action - alternate of Click()
		WebElement radioButton_Male = driver.findElement(By.xpath("//input[@id = 'male']"));
		js.executeScript("arguments[0].click()", radioButton_Male);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
