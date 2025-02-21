package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogpost.com/");
		driver.manage().window().maximize();
		
		// 1) Select a checkbox
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
		System.out.println(checkbox.isSelected());
		//checkbox.click();
		
		// 2) Count number of checkboxes in a page
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class = 'form-check-input' and @type = 'checkbox']"));		
		System.out.println("Number of checkboxes: " + checkboxes.size());
		
//		// 3) Select all the checkboxes
//		for (int i = 0; i < checkboxes.size(); i++)
//		{
//			checkboxes.get(i).click();
//		}
		
//		for (WebElement chkbox: checkboxes)
//		{
//			chkbox.click();
//		}
		
//		// 4) Select last 3 checkboxes
//		for (int i = 4; i < checkboxes.size(); i++)
//		{
//			checkboxes.get(i).click();
//		}
		
		
//		// 5) Select first 3 checkboxes
//		for (int i = 0; i < 2; i++)
//		{
//			checkboxes.get(i).click();
//		}
		
//		// 6) Select/Unselect checkboxes
//		for (WebElement chkbox: checkboxes)
//		{
//			if (chkbox.isSelected())
//			{
//				chkbox.click();	// unselect
//			}
//			else
//			{
//				chkbox.click();	// select
//			}
//		}
		
//		// 7) Select specific checkboxes randomly
//		for (int i = 0; i < checkboxes.size(); i++)
//		{
//			if (i==1 || i==3 || i==5)
//			{
//				checkboxes.get(i).click();
//			}
//		}
		
		// 8) Select a checkbox based on the value
		String day = "Sunday";
		
		switch (day) {
		case "Sunday":
			driver.findElement(By.xpath("//input[@id = 'sunday']")).click();
			break;
		case "Monday":
			driver.findElement(By.xpath("//input[@id = 'monday']")).click();
			break;
		case "Tuesday":
			driver.findElement(By.xpath("//input[@id = 'tuesday']")).click();
			break;
		case "Wednesday":
			driver.findElement(By.xpath("//input[@id = 'wednesday']")).click();
			break;
		case "Thursday":
			driver.findElement(By.xpath("//input[@id = 'thursday']")).click();
			break;
		case "Friday":
			driver.findElement(By.xpath("//input[@id = 'friday']")).click();
			break;
		case "Saturday":
			driver.findElement(By.xpath("//input[@id = 'saturday']")).click();
			break;
		default:
			System.out.println("Invalid week name");
			break;
		}
		
		
	}

}
