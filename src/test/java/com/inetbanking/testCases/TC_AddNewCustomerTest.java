package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomerTest extends BaseClass{

	LoginPage lp;
	AddCustomerPage acp;
	
	@Test
	public void addNewCustomerTest() throws IOException
	{
		lp = new LoginPage(driver);
		
		lp.setUserId(Uname);
		logger.info("Username Entered");
		
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.submitClick();
		logger.info("Submit Button is Clicked");
		
		acp = new AddCustomerPage(driver);
		
		acp.clickNewCustomerButton();
		logger.info("Create New Customer Button Clicked");
		
		acp.setCustomerName("c");
		logger.info("Customer Name is entered");
		
		acp.selectGenderMale();
		logger.info("Gender Male is selected");
		
		acp.setDOB("06", "23", "1992");
		logger.info("Date of Birth is enetered");
		
		acp.setAddress("c");
		logger.info("Address is entered");
		
		acp.setCity("c");
		logger.info("City is entered");
		
		acp.setState("c");
		logger.info("State is entered");
		
		acp.setPIN(123456);
		logger.info("PIN is entered");
		
		acp.setMobileNum("1");
		logger.info("Mobile Number is entered");
		
		acp.setEmail(randomString()+"@gmail.com");
		logger.info("Email ID is entered");
		
		acp.setPassword("c");
		logger.info("Password is entered");
		
		acp.clickSubmitButton();
		logger.info("Submit Button is Clicked");
		
		
		if(acp.newCustSuccessMsgpresent())
		{
			Assert.assertTrue(true);
			logger.info("New Customer Added Successfully");
		}
		else
		{
			capturescreen(driver, "addNewCustomerTest");
			logger.error("New Customer failed to add");
			Assert.assertTrue(false);
		}
	}
}
