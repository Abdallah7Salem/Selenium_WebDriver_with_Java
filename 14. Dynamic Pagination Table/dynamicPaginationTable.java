package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicPaginationTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id = 'input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space() = 'Login']")).click();
		
//		// Close window if displayed
//		if (driver.findElement(By.xpath("//button[@class = 'btn-close']")).isDisplayed())
//		{
//			driver.findElement(By.xpath("//button[@class = 'btn-close']")).click();		
//		}
	
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id = 'collapse-5']//a[contains(text(), 'Customers')]")).click();
		
		// Showing 1 to 10 of 17736 (1774 Pages)
		String text = driver.findElement(By.xpath("//div[contains(text(), 'Pages')]")).getText();
		int totalPagesNumber = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		
		// Opening pages
		for (int pageNumber = 1; pageNumber <= 3; pageNumber++)
		{
			if (pageNumber > 1)
			{
				WebElement activePage = driver.findElement(By.xpath("//ul[@class = 'pagination']//*[text() = '"+pageNumber+"']"));
				activePage.click();
			}
			
			// Count the number of data rows
			int numberOfRows = driver.findElements(By.xpath("//talbe[@class = 'table table-bordered table-hover']//tbody//tr")).size();
			
			// Read data from the page
			for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++)
			{
				String customerName = driver.findElement(By.xpath("//table[@class = 'table table-bordered table-hover']//tbody//tr["+rowNumber+"]/td[2]")).getText();
				String customerEmail = driver.findElement(By.xpath("//table[@class = 'table table-bordered table-hover']//tbody//tr["+rowNumber+"]/td[3]")).getText();
				String customerStatus = driver.findElement(By.xpath("//table[@class = 'table table-bordered table-hover']//tbody//tr["+rowNumber+"]/td[5]")).getText();
				
				System.out.println(customerName + "\t" + customerEmail + "\t" + customerStatus);
			}
			
			
		}
		
		
		
		
		
		
		

	}

}
