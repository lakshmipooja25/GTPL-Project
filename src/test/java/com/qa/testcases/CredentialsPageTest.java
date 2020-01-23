package com.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.base.TestBase;
import com.qa.pages.CredentialsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;
import com.qa.util.Utility;


@Listeners(com.qa.util.TestListener.class)

public class CredentialsPageTest extends TestBase{

	LoginPage loginPageobj;
	SignUpPage SignUpPageobj;
	CredentialsPage credentialspageobj;
	public CredentialsPageTest()
	{
		super();	
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		loginPageobj = new LoginPage();
		SignUpPageobj = new SignUpPage();
		credentialspageobj = new CredentialsPage();
		loginPageobj.clickHereMethod();
		SignUpPageobj.accessCredentials(prop.getProperty("acccessCredentialsEmailID"));
	}
	
	
	@Test(priority=1)
	
	public void verifyUserNamePasswordTest()
	{
		//Utility.switchToFrame();
		String UnamePswdValidation=credentialspageobj.verifyUserNamePassword(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(UnamePswdValidation, "Access details to demo site.");
		String trimmed_UnamePswdValidation=UnamePswdValidation.substring(0, 27);
		System.out.println(trimmed_UnamePswdValidation+" is validated");
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
