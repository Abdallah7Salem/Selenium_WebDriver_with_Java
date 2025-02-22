package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * 1) Handle country dropdown with/without  using Select class:
       https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
			a) count total number of options
			b) print all the options 
		    c) select one option
 */


public class HandleCountryDropdown_Task {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();		
				
		// a) count total number of options
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='country-list']/option"));		
		System.out.println(options.size());
		
		// b) print all the options
		for (WebElement op: options)
		{
			System.out.println(op.getText());
		}
		
		// c) select one option
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByVisibleText("USA");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
