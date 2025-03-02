package day43.pack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

	@Test
	void abc()
	{
		System.out.println("This is abc from C1...");
	}
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("This is BeforeTest method...");
	}
	
	
	
}
