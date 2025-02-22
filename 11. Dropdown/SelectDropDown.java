package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogpost.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Capture the dropdown element
		WebElement country = driver.findElement(By.id("country"));
	
		// Pass the dropdown element to Select Object
		Select selectCountry = new Select(country);
		
		// Select option from the drop down
		
		// Select by visible text
		// selectCountry.selectByVisibleText("France");
		
		// Select by value
		// selectCountry.deselectByValue("japan");
		
		// Select by index
		// the index is counted manually
		// selectCountry.selectByIndex(2);
		
		
		// Capture all the options from the dropdown
		List<WebElement> options = selectCountry.getOptions();
		System.out.println("Number of options in a dropdown: " + options.size());

		// Print the dropdown options
//		for (int i = 0; i < options.size(); i++)
//		{
//			System.out.println(options.get(i).getText());
//		}
		
		
		// Enhanced for loop
		for (WebElement op: options)
		{
			System.out.println(op.getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
