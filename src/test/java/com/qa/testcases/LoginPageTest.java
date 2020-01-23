package com.qa.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ManagerHomePage;
import com.qa.pages.SignUpPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	ManagerHomePage managerhmepg;
	 public LoginPageTest() {
		 super();	
	}
	 
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void getTitlePageTest()
	{
		String title=loginPage.getTitlePage();
		Assert.assertEquals(title,"GTPL Bank Home Page" );
	}
	//@Test(priority=2)
	public void getDemoSiteTextTest()
	{
		String demo_Text = loginPage.DemoSiteText();
		Assert.assertEquals(demo_Text, "Demo Site");
	}
	//@Test(priority=3)
	public void loginMethodTest()
	{
		managerhmepg  = loginPage.loginMethod(prop.getProperty("username"),prop.getProperty("password"));
		 
	}
	//@Test(priority=4)
	public void clickHereMethodTest() throws InterruptedException
	{
		
		loginPage.clickHereMethod();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
