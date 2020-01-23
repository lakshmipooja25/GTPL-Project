package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class ManagerHomePage extends TestBase{

	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustomer_Link ;
	
	public ManagerHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public NewCustomerPage VerifyNewCustomerLink()
	{
		
		NewCustomer_Link.click();
		return new NewCustomerPage();
	}
}
