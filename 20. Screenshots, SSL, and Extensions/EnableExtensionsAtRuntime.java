package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * 1) Add CRX Extractor/Downloader to Chrome Browser (Manually)
 * 2) Add SelectorHub plugin to chrome browser (Manually)
 * 3) Capture CRX file for selectorshub extension
 * 4) Pass CRX file path in automation script in Chrome Options
 */


public class EnableExtensionsAtRuntime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		File file = new File("D:\\Testing Career\\Learn Selenium with Java, Cucumber & Frameworks\\Section 39\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		options.addExtensions(file);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://text-compare.com/");
		
		
		
		
		
		
		
		
		
		
		

	}

}
