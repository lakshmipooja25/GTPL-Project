package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CredentialsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;
import com.qa.util.Utility;

public class SignUpPageTest extends TestBase{

	LoginPage loginpgobj;
	CredentialsPage credentialspageobj;
	SignUpPage SignUpPageobj;
	
	 public SignUpPageTest() {
	super();
	}
	@BeforeTest
	public void setUp()
	{
		initialisation();
		loginpgobj = new LoginPage();
		SignUpPageobj= new SignUpPage();
		loginpgobj.clickHereMethod();
	}
	
	
	
	@Test(priority=2)
	public void accessCredentialsTest()
	
	{
		
		credentialspageobj=SignUpPageobj.accessCredentials(prop.getProperty("acccessCredentialsEmailID"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
