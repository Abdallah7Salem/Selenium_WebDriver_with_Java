package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		// Switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1 = driver.findElement(By.xpath("//input[@id = 'field1']"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id = 'field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space() = 'Copy Text']"));
		
		
		// Clear the text in box1
		box1.clear();
		// Enter a new text in box1
		box1.sendKeys("Abdallah Qandil");
		
		// Double click action on button
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		
		// Validation: box2 is same as box1
		
		// This will not work as getText() returns the inner text
		// which is not available in this textbox
		// String box2Text = box2.getText();
		
		// Get text using getDomProperty("PLACE THE ATTRIBUTE HERE")
		// getDomProperty() -> returns the value of the attribute
		String box2Text = box2.getDomProperty("value");
		
		if(box2Text.equals("Abdallah Qandil"))
		{
			System.out.println("Text Copied..");
		}
		else
		{
			System.out.println("Text Not Copied Properly..");
		}
		
		
		
		
		
		
		
		
		
		

	}

}
