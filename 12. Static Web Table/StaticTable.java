package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogpost.com/");
		driver.manage().window().maximize();
		
		// 1) Find total number of rows in a table
		int numberOfRows = driver.findElements(By.xpath("//talbe[@name = 'BookTable']//tr")).size();		
		System.out.println("Number of Table Rows: " + numberOfRows);
		
		
		// 2) Find total number of columns in a table
		int numberOfColumns = driver.findElements(By.xpath("//table[@name = 'BookTable']")).size();
		System.out.println("Number of Table Columns: " + numberOfColumns);
		
		
		// 3) Read data from specific row and column (ex: 5th row 1st columns)
		String bookName = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr[5]//td[1]")).getText();
		System.out.println(bookName);
		
		
		// 4) Read data from all the rows and columns
//		for (int row = 2; row <= numberOfRows; row++)
//		{
//			for (int column = 1; column <= numberOfColumns; column++)
//			{
//				// Passing dynamic values into xpath
//				// syntax: "+value+"
//				String value = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+row+"]//td["+column+"]")).getText();
//				System.out.println(value + "\t");
//			}
//			System.out.println();
//		}
		
		
		// 5) Print book names whose author is Mukesh
//		for (int row = 2; row <= numberOfRows; row++)
//		{
//			String authorName = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+row+"]//td[2]")).getText();
//			
//			if (authorName.equals("Mukesh"))
//			{
//				String _bookName = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+row+"]//td[1]")).getText();
//				System.out.println(_bookName + "/t" + authorName);
//			}
//			
//		}
		
		
		// 6) Capture all books prices and find total price
		int totalPrice = 0;
		for (int row = 2; row <= numberOfRows; row++)
		{
			String bookPrice = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+row+"]//td[4]")).getText();
			totalPrice += Integer.parseInt(bookPrice);
		}
		
		System.out.println("Total Price of the books: " + totalPrice);
		
		
		
		
		
		
		
		

	}

}
