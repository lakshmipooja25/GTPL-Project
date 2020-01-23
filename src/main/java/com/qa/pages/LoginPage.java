package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="uid")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Demo Site')]")
	WebElement DemoSiteText;
	
	//@FindBy(xpath="//a[contains(text(),'here')]")
	@FindBy(linkText="here")
	WebElement clickHere;
	
	
	
	//initializing PageObjects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public  String getTitlePage()
	{
		
		return driver.getTitle();
	}
	
	public String DemoSiteText()
	{
		return DemoSiteText.getText();
	}
	public ManagerHomePage loginMethod(String uid, String pswd)
	{
		userName.sendKeys(uid);
		password.sendKeys(pswd);
		loginButton.click();
		return new ManagerHomePage();
	}
	
	public SignUpPage clickHereMethod()
	{
		
		clickHere.click();
		
		
		return new SignUpPage();
	}
	
	
	
	
	
	
	
	
	
	
	
}
