package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DepositPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ManagerHomePage;
import com.qa.pages.NewCustomerPage;
import com.qa.util.Utility;

public class ManagerHomeTest extends TestBase{

	LoginPage loginPageObj;
	ManagerHomePage managerHomePage;
	public ManagerHomeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		loginPageObj = new LoginPage();
		managerHomePage= new ManagerHomePage();
		loginPageObj.loginMethod(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void NewCustomerLinkTest()
	{
	
		managerHomePage.VerifyNewCustomerLink();
	}
}
