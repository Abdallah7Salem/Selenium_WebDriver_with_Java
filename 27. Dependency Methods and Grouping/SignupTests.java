package day44;

import org.testng.annotations.Test;

public class SignupTests {

	@Test (priority = 1, groups = {"regression"})
	void signupByEmail()
	{
		System.out.println("This is sign up by email...");
	}
	
	@Test (priority = 2, groups = {"regression"})
	void signupByFacebook()
	{
		System.out.println("This is sign up by facebook...");
	}
	
	@Test (priority = 3, groups = {"regression"})
	void signupByTwitter()
	{
		System.out.println("This is sign up by twitter...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
