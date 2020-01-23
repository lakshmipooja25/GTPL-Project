package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class SignUpPage extends TestBase{

	
	@FindBy(name="emailid")
	WebElement EmailID;
	
	@FindBy(name="btnLogin")
	WebElement submitButton;
	
	public SignUpPage()
	
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public CredentialsPage accessCredentials(String uname)
	{
		
		EmailID.sendKeys(uname);
		submitButton.click();
		return new CredentialsPage();
	}
	
}
