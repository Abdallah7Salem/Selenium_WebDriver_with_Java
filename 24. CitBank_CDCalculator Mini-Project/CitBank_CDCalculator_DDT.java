package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitBank_CDCalculator_DDT {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		// Reject cookies banner
		driver.findElement(By.xpath("//button[@id = 'onetrust-reject-all-handler']")).click();
		
		// 1) Get data from excel file
		String excelFilePath = System.getProperty("user.dir") + "\\testData\\caldata2.xlsx";

		int numOfRows = ExcelUtils.getNumOfRows(excelFilePath, "Sheet1");
		for (int rowNumber = 1; rowNumber <= numOfRows; rowNumber++) {

			String initialDepositAmount = ExcelUtils.getCellData(excelFilePath, "Sheet1", rowNumber, 0);
			String interestRate = ExcelUtils.getCellData(excelFilePath, "Sheet1", rowNumber, 1);
			String Length = ExcelUtils.getCellData(excelFilePath, "Sheet1", rowNumber, 2);
			String compounding = ExcelUtils.getCellData(excelFilePath, "Sheet1", rowNumber, 3);
			String expectedCDWorth = ExcelUtils.getCellData(excelFilePath, "Sheet1", rowNumber, 4);

			// Pass Excel Data to the Application
			WebElement initialDepositAmount_textBox = driver.findElement(By.id("mat-input-0"));
			initialDepositAmount_textBox.clear();
			initialDepositAmount_textBox.sendKeys(initialDepositAmount);

			WebElement lengthOfCDInMonths_textBox = driver.findElement(By.id("mat-input-1"));
			lengthOfCDInMonths_textBox.clear();
			lengthOfCDInMonths_textBox.sendKeys(Length);

			WebElement interestRate_textBox = driver.findElement(By.id("mat-input-2"));
			interestRate_textBox.clear();
			interestRate_textBox.sendKeys(interestRate);

			// Handling mat-select Dropdown
			WebElement matSelect = driver.findElement(By.xpath("//mat-select"));
			matSelect.click();

			// Select an option from compounding dropdown
			WebElement option = driver.findElement(By.xpath("//mat-option[contains(., '"+compounding+"')]"));
			option.click();
			
			
			WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']//div"));
			submitButton.click();
			
			// Validate The Result
			String actualCDWorth = driver.findElement(By.xpath("//span[@id = 'displayTotalValue']")).getText();
			if(actualCDWorth.equals(expectedCDWorth))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(excelFilePath, "Sheet1", rowNumber, 6, "Passed");
				ExcelUtils.fillGreenColor(excelFilePath, "Sheet1", rowNumber, 6);	
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(excelFilePath, "Sheet1", rowNumber, 6, "Failed");
				ExcelUtils.fillRedColor(excelFilePath, "Sheet1", rowNumber, 6);	
			}

		}	// End of the For Loop
		
		driver.quit();

		

	}

}
