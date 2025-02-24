package day34;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * word "date" is used to represent day and also the full date
 */

public class DatePickerDemo1 {

	static void selectFutureDate(WebDriver driver, String expectedMonth, String expectedYear, String expectedDate)
	{
		while (true)
		{
			String currentMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']")).getText();
		
			if (currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear))
			{
				break;
			}
			
			// Click the -> arrow for future dates
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
		}
	
		
		// Select the day (date)
		
		int numberOfDays = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//td[@data-handler = 'selectDay']")).size();
		
		for (int date = 1; date <= numberOfDays; date++)
		{
			String currentDate = driver.findElement(By.xpath("//a[@data-date = '"+date+"']")).getText();
			
			if (currentDate.equals(expectedDate))
			{
				driver.findElement(By.xpath("//a[@data-date = '"+date+"']")).click();
				break;
			}
			
		}
		
		
	}	
	
	
	static void selectPastDate(WebDriver driver, String expectedYear, String expectedMonth, String expectedDate)
	{
		while (true)
		{
			String currentMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']")).getText();
		
			if (currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear))
			{
				break;
			}

			// Click the <- arrow previous dates
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
		}
		
		// Select the day (date)
		
		int numberOfDays = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//td[@data-handler = 'selectDay']")).size();
		
		for (int date = 1; date <= numberOfDays; date++)
		{
			String currentDate = driver.findElement(By.xpath("//a[@data-date = '"+date+"']")).getText();
			
			if (currentDate.equals(expectedDate))
			{
				driver.findElement(By.xpath("//a[@data-date = '"+date+"']")).click();
				break;
			}
			
		}
		
		
	}	
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		// Switch to the frame
		driver.switchTo().frame(0);
		
		// Method 1: Using sendkeys()
		// driver.findElement(By.xpath("//input[@id = 'datepicker']")).sendKeys("02/24/2025");	// mm/dd/year
		
		
		// Method 2: Using date picker
		
		// Expected Date
		String expectedYear = "2026";
		String expectedMonth = "March";
		String expectedDate = "31"; 
		
		
		driver.findElement(By.xpath("//input[@id = 'datepicker']")).click();
		
		selectFutureDate(driver, expectedYear, expectedMonth, expectedDate);
		
		
		
		
		
		
		
		

	}

}
