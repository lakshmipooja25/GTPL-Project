package com.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ManagerHomePage;
import com.qa.pages.NewCustomerPage;
import com.qa.util.Utility;

public class NewCustomerPageTest extends TestBase{

	LoginPage loginPageObj;
	ManagerHomePage managerHomePageObj;
	NewCustomerPage newCustomerPage ;
	
	public NewCustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		loginPageObj = new LoginPage();
		managerHomePageObj= new ManagerHomePage();
		newCustomerPage = new NewCustomerPage();
		
		loginPageObj.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
		managerHomePageObj.VerifyNewCustomerLink();
		
	}
	
	@DataProvider
	public Object[][] getNewContactsData(){
		Object data[][] = Utility.getTestData("New Customer");
		return data;
	}
	
	@Test(dataProvider="getNewContactsData")
	public void NewCustomer_DataEntry_Test(String name, String gender, String dob, String addr, String city, String state, 
			String pinno, String mobno, String emailid)
	{
		
		newCustomerPage.NewCustomer_DataEntry(name, gender, dob, addr, city, state, pinno, mobno, emailid);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		//newCustomerPage.NewCustomer_DataEntry("lakshmi", "female", "25/03/1994", "Kodambakkam", "Chennai", "TamilNadu", "600024", "8939393977", "laksh@gmail.com");
	}
	
	
	
	
	
	
	
}
