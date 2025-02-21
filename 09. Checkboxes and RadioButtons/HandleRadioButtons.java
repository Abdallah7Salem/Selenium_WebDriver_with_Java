package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRadioButtons {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogpost.com/");
		driver.manage().window().maximize();

		WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));
		
		male_rd.click();
		System.out.println("Male radio button is selected: " + male_rd.isSelected());

		female_rd.click();
		System.out.println("Female radio button is selected: " + female_rd.isSelected());
		
		
		
	}

}
