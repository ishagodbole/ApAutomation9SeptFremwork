package com.odoo.ap.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.ap.pagelayer.Homepage;
import com.odoo.ap.pagelayer.Loginpage;
import com.odoo.ap.pagelayer.Signuppage;
import com.odoo.ap.testbase.TestBase;
import com.odoo.ap.utility.CommonUIstep;

public class SignupTest extends TestBase {
	
	@Test
	public void verifySignupWithValidDetails()
	{
		String expected_result = "My Portal | testing";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Signuppage signuppage_obj = new Signuppage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		
		signuppage_obj.enterEmailAddress("test12@gmail.com");
		signuppage_obj.enterUsername("test3");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verifySignupWithAlreadyRegisterEmail()
	{
		String expected_result = "Another user is already registered using this email address.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Signuppage signuppage_obj = new Signuppage(driver);
		CommonUIstep common_obj = new CommonUIstep(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		
		signuppage_obj.enterEmailAddress("test12@gmail.com");
		signuppage_obj.enterUsername("test3");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = common_obj.getErrorMessageFromPage();
		Assert.assertEquals(actual_result, expected_result);
	}


}
