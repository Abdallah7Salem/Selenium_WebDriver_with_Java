package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String excelFilePath = System.getProperty("user.dir") + "\\testData\\caldata.xlsx";
		
		int numOfRows = ExcelUtils.getNumOfRows(excelFilePath, "Sheet1");
		
		// Handle the popup
		driver.findElement(By.id("wzrk-cancel")).click();
		
		
		for (int r = 1; r <= numOfRows; r++)
		{
			// 1) Read data from excel
			String principle = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 0);
			String rateOfInterest = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 1);
			String period1 = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 2);
			String period2 = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 3);
			String frequency = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 4);
			String expected_matval = ExcelUtils.getCellData(excelFilePath, "Sheet1", r, 5);
			
			
			// 2) Pass above data into application
			driver.findElement(By.xpath("//input[@id = 'principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id = 'interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id = 'tenure']")).sendKeys(period1);
			
			Select periodDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'tenurePeriod']")));
			periodDropdown.selectByVisibleText(period2);
			 
			Select frequencyDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'frequency']")));
			frequencyDropdown.selectByVisibleText(frequency);
			
			// Click on calculate button
			driver.findElement(By.xpath("//div[@class = 'CTR PT15']//a[1]")).click();	// Clicked on calculate
			
			// 3) Validate the result
			String actual_matval = driver.findElement(By.xpath("//span[@id = 'resp_matval']//strong")).getText();
			
			if (Double.parseDouble(expected_matval) == Double.parseDouble(actual_matval))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(excelFilePath, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColor(excelFilePath, "Sheet1", r, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(excelFilePath, "Sheet1", r, 7, "Failed");
				ExcelUtils.fillRedColor(excelFilePath, "Sheet1", r, 7);

			}
			
			// Click the clear button
			driver.findElement(By.xpath("//img[@class = 'PL5']")).click();
			
		}	// End of the The For Loop
		
		driver.quit();
		
	}	// End of the Main Method
	
}	// End of the Class
