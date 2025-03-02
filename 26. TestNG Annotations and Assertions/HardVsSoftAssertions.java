package day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	@Test
	void test_hardAssertions()
	{
		System.out.println("Testing");
	
		// Hard Assertion
		// In case of failure => The rest code in test case will not execute
		// So, it should be the last statement in any test method
		Assert.assertEquals(1, 2);
		
		System.out.println("Testing.....");
		
	}
	
	@Test
	void test_softAssertion()
	{
		System.out.println("Testing");
		
		// Soft Assertion
		// Methods are not static, we must create an object
		SoftAssert sa = new SoftAssert();	
		sa.assertEquals(1, 2);
		
		System.out.println("Testing...");
		
		// Problem: Soft Assertion will always pass
		// This method solves this problem
		sa.assertAll();	// Mandatory
		
	}
	
	
	
	
	
}
