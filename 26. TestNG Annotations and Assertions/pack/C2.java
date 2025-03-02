package day43.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {

	@Test
	void xyz()
	{
		System.out.println("This is abc from C1...");
	}
	
	@AfterTest
	void afterTest()
	{
		System.out.println("This is BeforeTest method...");
	}
	
	
	
	
	
	
}
