package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");

		driver.manage().window().maximize();
		
		// Login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space() = 'Login']")).click();
		
		// Click on PIM
		driver.findElement(By.xpath("//span[normalize-space() = 'PIM']")).click();
		
		// Click the dropdown
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		
		// Select a single option
		// driver.findElement(By.xpath("//span[normalize-space() = 'Financial Analyst']")).click();
		
		// Count number of options
		List<WebElement> options = driver.findElements(By.xpath("//div[@role = 'listbox']//span"));
		System.out.println("Number of options: " + options.size());
		
		// Print dropdown options
		for (WebElement op: options)
		{
			System.out.println(op.getText());
		}
		
		
		
		
		
		
		

	}

}
