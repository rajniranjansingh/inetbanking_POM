package com.inetbanking.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;

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
	
	@AfterMethod
	public void writeResult(ITestResult result)
	{
		System.out.println("Result of Login Test after execution is : "+result.getStatus());
		if(result.getStatus() == 1)
		{
			given().log().all()
			.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Pune")
			.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat()
			.body("City", equalTo("Pune"))
			.header("content-type", "application/json").log().all();
			System.out.println("PASSED!!!!!!!!!!!!!!!!!!!!!");
		}
		else
		{
			System.out.println("FAILED!!!!!!!!!!!!!!!!!!!!!");
		}
	}
}
