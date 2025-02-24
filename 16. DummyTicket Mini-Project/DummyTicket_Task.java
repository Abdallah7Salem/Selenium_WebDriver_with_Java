package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummyTicket_Task {
		
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/");
		driver.manage().window().maximize();
		
		// Click Buy Ticket button
		driver.findElement(By.xpath("//a[contains(text(),'Buy Ticket')]")).click();
		
		// Select dummy ticket and hotel radio button
		driver.findElement(By.id("product_3186")).click();
		
		// Enter first name and last name
		driver.findElement(By.id("travname")).sendKeys("Abdallah");
		driver.findElement(By.id("travlastname")).sendKeys("Salem");
		
		// Enter birth date
		// 6 Mar 2001
		String passenger1_birthYear = new String("2001");
		String passenger1_birthMonth = new String("Mar");
		String passenger1_birthDay = new String("6");
		
		String datePicker1_ID = "dob";	// Got the ID using Dev Tools
		driver.findElement(By.xpath("//input[@id = '"+datePicker1_ID+"']")).click();
		
		selectDate(driver, passenger1_birthYear, passenger1_birthMonth, passenger1_birthDay);

		
		// Select male radio button in gender
		driver.findElement(By.id("sex_1")).click();
		
		// Select Checkbox : Add more passengers
		driver.findElement(By.id("addmorepax")).click();
		
		// Handle hidden dropdown
		
		// Open the number of passengers dropdown 
		driver.findElement(By.xpath("//span[@role = 'combobox']//*[@id = 'select2-addpaxno-container']")).click();
		
		// Select  add 1 more passenger (100%)
		WebDriverWait numOfPassengersWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addOnePassengerOption = numOfPassengersWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'add 1 more passenger (100%)')]")));
		addOnePassengerOption.click();

		// Enter passenger 2 details
		driver.findElement(By.id("travname2")).sendKeys("Abdallah");
		driver.findElement(By.id("travlastname2")).sendKeys("Qandil");
		
	
		// Enter birth date
		// 7 Jan 2000
		String passenger2_birthYear = new String("2000");
		String passenger2_birthMonth = new String("Jan");
		String passenger2_birthDay = new String("7");
		
		// Open the date picker
		String datePicker2_ID = "dob2";	// Got the ID using Dev Tools
		driver.findElement(By.xpath("//input[@id = '"+datePicker2_ID+"']")).click();
		
		selectDate(driver, passenger2_birthYear, passenger2_birthMonth, passenger2_birthDay);

		// Select gender of passenger 2 => male
		driver.findElement(By.id("sex2_1")).click();
		
		
		// Select Trip Type => One way
		driver.findElement(By.xpath("//input[@name = 'traveltype']")).click();
		
		// Enter departure and destination cities
		driver.findElement(By.id("fromcity")).sendKeys("Cairo");
		driver.findElement(By.id("tocity")).sendKeys("USA");
		
		// Choose departure date from date picker
		String departureYear = new String("2026");
		String departureMonth = new String("Jan");
		String departureDay = new String("1");
		
		String departureDate_ID = "departon";	// Got the ID using Dev Tools
		driver.findElement(By.xpath("//input[@id= '"+departureDate_ID+"']")).click();
		
		selectDate(driver, departureYear, departureMonth, departureDay);
		
		// Open the purpose of dummy ticket dropdown menu
		driver.findElement(By.xpath("//span[@role = 'combobox']//*[@id = 'select2-reasondummy-container']")).click();
				
		// Select Visa extension
		WebDriverWait ticketPurposeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ticketPurposeOption = ticketPurposeWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Visa extension')]")));
		ticketPurposeOption.click();	
		
		
		// Select to receive the dummy ticket by email
		driver.findElement(By.id("deliverymethod_1")).click();
		
		// Enter Phone Number
		driver.findElement(By.id("billing_phone")).sendKeys("0123456789");
		
		// Enter Email Address
		driver.findElement(By.id("billing_email")).sendKeys("abdallahalaasalem7@gmail.com");
		
		// Enter address details
		driver.findElement(By.id("billing_address_1")).sendKeys("Cairo");
		driver.findElement(By.id("billing_city")).sendKeys("Cairo");
		
		driver.findElement(By.id("select2-billing_state-container")).click();
		WebDriverWait stateWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement stateOption = stateWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Cairo')]")));
		stateOption.click();
		
		driver.findElement(By.id("billing_postcode")).sendKeys("51592");
		
		// Switch to Payment Iframe
		driver.switchTo().frame(0);
		
		// Enter credit card details
		driver.findElement(By.id("Field-numberInput")).sendKeys("5494 0736 7865 5530");
		driver.findElement(By.id("Field-expiryInput")).sendKeys("07/28");
		driver.findElement(By.id("Field-cvcInput")).sendKeys("740");
		
		
		// Switch to default page
		driver.switchTo().defaultContent();
		
		// Click place order
		driver.findElement(By.id("place_order")).click();
		
		
	}

	
	
	static void selectDate(WebDriver driver, String year, String month, String day)
	{
				
				// Select year from the dropdown 
				WebElement Year = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-year']"));
				Select selectBirthYear = new Select(Year);
				selectBirthYear.selectByValue(year);
				
				// Select month from the dropdown 
				WebElement Month = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));
				Select selectBirthMonth = new Select(Month);
				selectBirthMonth.selectByVisibleText(month);
				
				// Select day from the table 
				List<WebElement> totalMonthDays = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody//tr//a"));
				
				
				for (WebElement currentDay: totalMonthDays)
				{
					String dayNumber = currentDay.getText();
					if (dayNumber.equals(day))
					{
						driver.findElement(By.xpath("//a[@data-date = '"+dayNumber+"']")).click();
						break;
					}
				}
	}
	
	
}
