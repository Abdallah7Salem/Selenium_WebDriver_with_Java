package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		// Open dropdown options
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();
		
		// 1) Select a single option
		driver.findElement(By.xpath("//input[@value = 'Java']")).click();
		
		// 2) Capture all the options and find out the size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//label"));
		System.out.println("Number of options: " + options.size());
		
		// 3) Print the dropdown options
//		for (WebElement op: options)
//		{
//			System.out.println(op.getText());
//		}
		
		// 4) Select multiple options
		for (WebElement op: options)
		{
			String option = op.getText();
			
			if (option.equals("Java") || option.equals("Python") || option.equals("MySQL"))
			{
				op.click();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
