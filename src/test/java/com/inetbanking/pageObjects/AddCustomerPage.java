package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerButton;
	
	@FindBy(name = "name")
	WebElement customerName;
	
	@FindBy(xpath = "//input[@value='m']")
	WebElement genderMale;
	
	@FindBy(xpath = "//input[@value='f']")
	WebElement genderFemale;
	
	@FindBy(id = "dob")
	WebElement dateOfBirth;
	
	@FindBy(name = "addr")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement cityName;
	
	@FindBy(name = "state")
	WebElement stateName;
	
	@FindBy(name = "pinno")
	WebElement pinNum;
	
	@FindBy(name = "telephoneno")
	WebElement mobileNum;
	
	@FindBy(name = "emailid")
	WebElement emailID;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "sub")
	WebElement submitButton;
	
	@FindBy(xpath = "//p[contains(text(),'Customer Registered Successfully!!!')]")
	WebElement newCustomerAddedSuccess;
	
	public void clickNewCustomerButton()
	{
		newCustomerButton.click();
	}
	
	public void setCustomerName(String cname)
	{
		customerName.sendKeys(cname);
	}
	
	public void selectGenderMale()
	{
		genderMale.click();
	}
	
	public void selectGenderFemale()
	{
		genderFemale.click();
	}
	
	public void setDOB(String mm, String dd, String yyyy)
	{
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void setCity(String city)
	{
		cityName.sendKeys(city);
	}
	
	public void setState(String state)
	{
		stateName.sendKeys(state);
	}
	
	public void setPIN(int pin)
	{
		pinNum.sendKeys(String.valueOf(pin)); //String.valueOf() method will convert any value to string format because sendKeys method will only accept Strings 
	}
	
	public void setMobileNum(String mobile)
	{
		mobileNum.sendKeys(mobile);
	}
	
	public void setEmail(String email)
	{
		emailID.sendKeys(email);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public boolean newCustSuccessMsgpresent()
	{
		boolean a = newCustomerAddedSuccess.isDisplayed();
		return a;
	}
}