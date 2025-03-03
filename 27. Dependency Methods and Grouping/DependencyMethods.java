package day44;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	@Test (priority = 1)
	void openApp()
	{
		Assert.assertTrue(false);
	}
	
	@Test (priority = 2, dependsOnMethods = {"openApp"})
	void login()
	{
		
	}
	
	@Test (priority = 3, dependsOnMethods = {"login"})
	void search()
	{
		
	}
	
	@Test (priority = 4, dependsOnMethods = {"login", "search"})
	void advancedSearch()
	{
		
	}
	
	@Test (priority = 5, dependsOnMethods = {"login"})
	void logout()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
