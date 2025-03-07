package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * 1- Data is valid - login success - test pass - logout
 * 2- Data is valid - login failed - test fail
 * 
 * 3- Data is invalid - login success - test fail - logout
 * 4- Data is invalid - login failed - test pass
 */

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // Getting data provider from different
																				// class
	public void verify_LoginDDT(String email, String pwd, String expectedResult) {

		logger.info("***** Started TC_003_LoginDDT *****");
		
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// My Account Page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExisting();

			if (expectedResult.equalsIgnoreCase("Valid")) // Valid data
			{
				if (targetPage == true) // Successful Login
				{
					macc.clickLogout(); // Logout
					Assert.assertTrue(true); // Test Passed
				} else // Failed Login
				{
					Assert.assertTrue(false); // Test Failed
				}
			}

			if (expectedResult.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) // Successful Login
				{
					macc.clickLogout(); // Logout
					assertTrue(false); // Test Failed
				} else {
					Assert.assertTrue(true); // Test Passed
				}
			}

		} catch (Exception e) {

		}

		logger.info("***** Finished TC_003_LoginDDT *****");
	}

}
