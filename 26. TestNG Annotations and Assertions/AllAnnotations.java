package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	
	@BeforeSuite
	void beforeSuite()
	{
		System.out.println("This is BeforeSuite method...");
	}
	
	@AfterSuite
	void afterSuite()
	{
		System.out.println("This is AfterSuite method...");
	}	
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("This is BeforeTest method...");
	}
	
	@AfterTest
	void afterTest()
	{
		System.out.println("This is AfterTest method...");
	}	
	
	@BeforeClass
	void beforeClass()
	{
		System.out.println("This is BeforeClass method...");
	}
	
	@AfterClass
	void afterClass()
	{
		System.out.println("This is AfterClass method...");
	}	
	
	@BeforeMethod
	void beforeMethod()
	{
		System.out.println("This is BeforeMethod ...");
	}
	
	@AfterMethod
	void afterMethod()
	{
		System.out.println("This is AfterMethod ...");
	}	
	
	@Test
	void testMethod1()
	{
		System.out.println("This is Test Method1... ");
	}
	
	@Test
	void testMethod2()
	{
		System.out.println("This is Test Method2... ");
	}
	
}
