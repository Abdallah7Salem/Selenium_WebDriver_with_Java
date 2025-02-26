package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		
		Actions act = new Actions(driver);
		
		
		// Capture the source element
		WebElement sourceElement_Rome = driver.findElement(By.xpath("//div[@id = 'box6']"));
		// Capture the destination element
		WebElement destinationElement_Italy = driver.findElement(By.xpath("//div[@id = 'box106']"));
		// Perform the drag and drop action
		act.dragAndDrop(sourceElement_Rome, destinationElement_Italy).perform();
		
		
		// Capture the source element
		WebElement sourceElement_Washington = driver.findElement(By.xpath("//div[@id = 'box3']"));
		// Capture the destination element
		WebElement destinationElement_US = driver.findElement(By.xpath("//div[@id = 'box103']"));
		// Perform the drag and drop action
		act.dragAndDrop(sourceElement_Washington, destinationElement_US).perform();
		
		
		
		
		
		
		
		
		

	}

}
