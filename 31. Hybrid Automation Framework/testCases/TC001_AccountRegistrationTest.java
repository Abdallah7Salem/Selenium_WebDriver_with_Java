package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString() + "@gmail.com");
		regPage.setTelephone(randomNumber());

		String pwd = randomAlphaNumeric();
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);

		regPage.setPrivacyPolicy();
		regPage.clickContinue();

		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}

}
