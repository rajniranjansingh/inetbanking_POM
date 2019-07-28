package com.inetbanking.testCases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);

		lp.setUserId(Uname);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.submitClick();
		logger.info("Submit Button is Clicked");

		if(driver.getTitle().equals(HomePageTitle))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			capturescreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.error("Login Test failed");
		}
	}
}
