package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktops = driver.findElement(By.xpath("//a[normalize-space() = 'Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space() = 'Mac (1)']"));
		
		Actions act = new Actions(driver);
		
		// Mouse Hover Action
		
		// 1) explicit action creation: using build() and perform()
		// act.moveToElement(desktops).moveToElement(mac).click().build().perform();
		
		// 2) implicit action creation: using perform() only
		act.moveToElement(desktops).moveToElement(mac).click().perform();
		

	}

}
