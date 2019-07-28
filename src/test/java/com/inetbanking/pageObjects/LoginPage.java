package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	WebElement UserId;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "btnLogin")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement LogoutBtn;
	
	public void setUserId(String uid)
	{
		UserId.sendKeys(uid);
	}
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void submitClick()
	{
		LoginBtn.click(); 
	}
	
	public void clickLogout()
	{
		LogoutBtn.click();
	}

}