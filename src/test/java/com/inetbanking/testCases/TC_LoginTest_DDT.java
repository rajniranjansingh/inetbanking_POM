package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTest_DDT extends BaseClass{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String un, String pw) throws IOException
	{
		LoginPage lp = new LoginPage(driver);

		lp.setUserId(un);
		logger.info("Username Entered");
		
		lp.setPassword(pw);
		logger.info("Password Entered");
		
		lp.submitClick();
		logger.info("Submit Button is clicked");

		if(isAlertPresent())
		{
			logger.error("Wrong Username / Password");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Logged in Successfully");
			if(driver.getTitle().equals(HomePageTitle))
			{
				logger.info("Title is correct");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Title is correct");
				Assert.assertTrue(false);
			}
			lp.clickLogout();
			logger.info("Logout Button is clicked");
			
			isAlertPresent();
			logger.info("Logged out Successfully");
		}
	}

	public static boolean isAlertPresent()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		}
		catch(Exception a)
		{
			return false;
		}	
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Data.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 0);

		Object data [][] = new Object [rownum][colnum];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0; j<colnum;j++)
			{
				data [i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return data;
	}
}
