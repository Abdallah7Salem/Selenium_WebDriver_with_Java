package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1) Login -- @BeforeMethod
 * 2) Search -- @Test
 * 3) Logout -- @AfterMethod
 * 4) Login
 * 5) Advanced search --- @Test
 * 6) Logout
 */

public class AnnotationsDemo1 {

	@BeforeMethod
	void login()
	{
		System.out.println("This is login...");
	}
	
	@Test (priority = 1)
	void search()
	{
		System.out.println("This is search...");
	}
	
	@Test (priority = 2)
	void advancedSearch()
	{
		System.out.println("This is advanced search...");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("This is logout...");
	}
	
	
	
	
	
	
	
}
