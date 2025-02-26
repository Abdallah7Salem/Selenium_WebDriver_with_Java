package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[@class = 'context-menu-one btn btn-neutral']"));
		
		// Actions --> A class used to perform mouse actions
		Actions act = new Actions(driver);
		
		// Action --> An interface used to store created actions
		// Create/Build and action and store it into a variable
		Action myAction = act.contextClick(button).build();
		// Perform the action
		myAction.perform();
		
		
		
		
		
		
		

	}

}
