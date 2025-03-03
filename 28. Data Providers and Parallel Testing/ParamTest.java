package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String br, String url)
	{
		switch(br.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox": 
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			// To exit from the method in case of invalid browser
			return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	
	@Test (priority = 1)
	void testLogo()
	{
		boolean status = driver.findElement(By.xpath("//img[@alt = 'company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		
	}
	
	@Test (priority = 2)
	void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test (priority = 3)
	@Parameters ({"url"})
	void testURL(String url)
	{
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
