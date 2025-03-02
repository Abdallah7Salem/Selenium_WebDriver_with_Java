package day42;

import org.testng.annotations.Test;

/*
 * 1) Open the application
 * 2) Login
 * 3) Logout
 */

public class myFirstTestCase {

	@Test (priority = 1)
	void openApp()
	{
		System.out.println("Open the application");
	}
	
	@Test (priority = 2)
	void login()
	{
		System.out.println("Login to the application");
	}
	
	@Test (priority = 3)
	void logout()
	{
		System.out.println("Logout from the application");
	}
	
	
	
	
	
	
	
}
