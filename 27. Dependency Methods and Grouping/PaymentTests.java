package day44;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test (priority = 1, groups = {"sanity", "regression", "functional"})
	void paymentInEgyptianPounds()
	{
		System.out.println("This is payment in Egyptian pounds...");
	}
	
	@Test (priority = 2, groups = {"sanity", "regression", "functional"})
	void paymentInDollars()
	{
		System.out.println("This is payment in dollars...");
	}
	
	
	
	
	
	
	
	
	
	
	
}
