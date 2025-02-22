package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingInnerFrameTask {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// Switch to frame 5
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src = 'frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		// Click the link in frame 5 to open new iframe
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		// Check logo presence in the inner frame
		WebElement logo = driver.findElement(By.id("logo"));
		System.out.println(logo.isDisplayed());
		
		
		

	}

}
