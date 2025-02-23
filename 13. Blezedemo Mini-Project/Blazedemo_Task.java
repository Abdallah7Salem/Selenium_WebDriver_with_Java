package day32;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Blazedemo_Task {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Open the website
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		// Select the departure city from the dropdown
		WebElement departureCityDropdown = driver.findElement(By.xpath("//select[@name = 'fromPort']"));
		Select selectDepartureCity = new Select(departureCityDropdown);
		selectDepartureCity.selectByValue("Paris");
		
		// Select the destination city from the dropdown
		WebElement destinationCityDropdown = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select selectDestinationCity = new Select(destinationCityDropdown);
		selectDestinationCity.selectByValue("Cairo");	
		
		// Click find flights button
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		// Find the flight with lowest price
		
		driver.findElement(By.xpath("//table[@class = 'table']"));		
		int numberOfRows = driver.findElements(By.xpath("//table[@class = 'table']//tr")).size();
		String[] flightsPrices = new String[numberOfRows-1];
		
		for (int row = 1; row < numberOfRows; row++)
		{
			String flightPrice = driver.findElement(By.xpath("//table[@class = 'table']//tr["+row+"]//td[6]")).getText();
			flightsPrices[row-1] = flightPrice;
			System.out.println(flightPrice);
		}
		
		// Sort the prices to get the lowest
		Arrays.sort(flightsPrices);
		System.out.println(Arrays.toString(flightsPrices));
		
		// Choose the flight with lowest price
		for (int tableRow = 1; tableRow < numberOfRows; tableRow++)
		{
			String flightPrice = driver.findElement(By.xpath("//table[@class = 'table']//tr["+tableRow+"]//td[6]")).getText();
			if (flightsPrices[0].equals(flightPrice))
			{
				// Click "Choose This Flight"
				driver.findElement(By.xpath("(//input[@value='Choose This Flight'])["+tableRow+"]")).click();
				// break is a must
				break;
			}
		}
		
		
		// Enter all details [name - address - city - state - zipcode]
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Abdallah Qandil");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Cairo, Egypt");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Cairo");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Cairo");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");
	
		// Select card type from the dropdown
		WebElement cardTypeDropdown = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select selectCardType = new Select(cardTypeDropdown);
		selectCardType.selectByVisibleText("Visa");
		
		// Enter card details
		driver.findElement(By.id("creditCardNumber")).sendKeys("1234 5678 9123 4567");
		driver.findElement(By.id("creditCardMonth")).sendKeys("2");
		driver.findElement(By.id("creditCardYear")).sendKeys("2025");
		driver.findElement(By.id("nameOnCard")).sendKeys("Abdallah Alaa Salem");
		
		// Click the remember me checkbox
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		
		// Click purchase flight button
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		// Validate Confirmation Message
		String confirmationMessage = driver.findElement(By.xpath("//div[@class = 'container hero-unit']//h1")).getText();
		if (confirmationMessage.equals("Thank you for your purchase today!"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		
		
		
		

	}

}
