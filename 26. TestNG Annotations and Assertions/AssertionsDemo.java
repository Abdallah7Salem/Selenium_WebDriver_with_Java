package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	void testTitle()
	{
		String expectedTitle = "Opencart";
		String actualTitle = "Openshop";
		
//		if (expectedTitle.equals(actualTitle))
//		{
//			System.out.println("Test Passed");
//		}
//		else
//		{
//			System.out.println("Test Failed");
//		}
		
		// Assert.assertEquals(expectedTitle, actualTitle);
		
		if (expectedTitle.equals(actualTitle))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	
	
	
}
