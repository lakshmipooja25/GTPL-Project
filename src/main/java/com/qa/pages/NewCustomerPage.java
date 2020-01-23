package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class NewCustomerPage extends TestBase{

	@FindBy(name="name")
	WebElement customer_Name;
	
	@FindBy(xpath="//table[@class='layout']//tr[5]//td[2]//child::input[1]")
	WebElement customer_gender_male;
	
	@FindBy(xpath="//table[@class='layout']//tr[5]//td[2]//child::input[2]")
	WebElement customer_gender_female;
	
	
	@FindBy(name="dob")
	WebElement customer_DOB;
	
	@FindBy(name="addr")
	WebElement customer_addr;
	
	@FindBy(name="city")
	WebElement customer_city;
	
	@FindBy(name="state")
	WebElement customer_state;
	
	@FindBy(name="pinno")
	WebElement customer_pinNo;
	
	@FindBy(name="telephoneno")
	WebElement customer_mobNo;
	
	@FindBy(name="emailid")
	WebElement customer_emailID;
	
	@FindBy(name="password")
	WebElement customer_password;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitButton;
	
	public NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void NewCustomer_DataEntry(String name, String gender, String dob, String addr, String city, String state, 
			String pinno, String mobno, String emailid )
	{
		customer_Name.sendKeys(name);
		
		if (gender.equalsIgnoreCase("male")) {
			customer_gender_male.click();
		}
		else if(gender.equalsIgnoreCase("female"))
		{
			customer_gender_female.click();
		}
		
		customer_DOB.sendKeys(dob);
		customer_addr.sendKeys(addr);
		customer_city.sendKeys(city);
		customer_state.sendKeys(state);
		customer_pinNo.sendKeys(pinno);
		customer_mobNo.sendKeys(mobno);
		customer_emailID.sendKeys(emailid);
		
		submitButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
