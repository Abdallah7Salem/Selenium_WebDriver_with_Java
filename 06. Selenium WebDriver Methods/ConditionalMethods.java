package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		// isDisplayed
		
		//WebElement logo = driver.findElement(By.xpath("//img[@alt = 'nopCommerce demo store']"));
		//System.out.println("Display status of logo: " + logo.isDisplayed());
		
		//boolean status = driver.findElement(By.xpath("//img[@alt = 'nopCommerce demo store']")).isDisplayed();
		//System.out.println("Display status: " + status);
		
		
		// isEnabled()
		boolean status = driver.findElement(By.xpath("//input[@id = 'FirstName']")).isEnabled();
		System.out.println("Enable status: " + status);
		
		// isSelected()
		WebElement male_radioButton = driver.findElement(By.xpath("//input[@id = 'gender-male']"));
		WebElement female_radioButton = driver.findElement(By.xpath("//input[@id = 'gender-female']"));
		
		System.out.println("Before selection:");
		System.out.println(male_radioButton.isSelected());		// false
		System.out.println(female_radioButton.isSelected());	// false
		
		System.out.println("After selecting male:");
		male_radioButton.click();
		System.out.println(male_radioButton.isSelected());		// true
		System.out.println(female_radioButton.isSelected());	// false
		
		System.out.println("After selecting female:");
		female_radioButton.click();
		System.out.println(male_radioButton.isSelected());		// false
		System.out.println(female_radioButton.isSelected());	// true
		
		boolean newsletterStatus = driver.findElement(By.xpath("//input[@id = 'Newsletter']")).isSelected();
		System.out.println("News letter checkbox status: " + newsletterStatus);
		
	}

}
