package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * 1) Open application "https://www.demoblaze.com/index.html"
 * 2) Count total number of links
 * 3) Count total number of images
 * 4) Click on Any product link using linkText / partialLinkText
 */

public class LocatorsDemo {
	
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		// 1) Open application
		driver.get("https://www.demoblaze.com/index.html");
		// 2) Count total number of Links
		List<WebElement> links = driver.findElements(By.className("a"));
		System.out.println("Total Number of Links:" + links.size());
		// 3) Count total number of images
		List<WebElement> images = driver.findElements(By.className("img"));
		System.out.println("Total Number of Images:" + images.size());
		// 4) Click on Any product link using linkText
		driver.findElement(By.linkText("Samsung galaxy s6")).click();
		
	}


	
}
