package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// First, Capture the current location of the slider
		// Then, modify the value of x-axis or y-axis
		
		// Minimum Slider
		WebElement min_slider = driver.findElement(By.xpath("//div[@class = 'price-range-block']//span[1]"));
		System.out.println("Default location of the min slider: " + min_slider.getLocation());	//(59, 251) = (x, y) 	
		// Moving the minimum slider horizontally
		act.dragAndDropBy(min_slider, 100, 251).perform();
		System.out.println("Location of the min slider after moving: " + min_slider.getLocation());	//(159, 251) = (x, y)
		
		// Maximum Slider
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default location of the max slider: " + max_slider.getLocation());	//(314, 234) = (x, y)
		act.dragAndDropBy(max_slider, -49, 234).perform();
		System.out.println("Location of the max slider after moving: " + max_slider.getLocation());
		
		
		
		
		
		
		

	}

}
