package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

 public class CredentialsPage extends TestBase {

	 String result;
	 @FindBy(xpath="//td[text()='User ID :']")
	 WebElement UserIDText;
	 
	 @FindBy(xpath="//td[text()='Password :']")
	 WebElement PasswordText;
	 
	 @FindBy(xpath="//td[text()='mngr242369 ']")
	 WebElement UserIDTextValue;
	 
	 @FindBy(xpath="//td[contains(text(),'jemevyh')]")
	 WebElement PasswordTextValue;
	 
	 @FindBy(xpath="//h2[contains(text(),'Access details to demo site.')]")
	 WebElement AccessDetailsInfo;
	
	 public CredentialsPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	 
	 public String verifyUserNamePassword(String uname,String pswd)
	 {
		 if (UserIDTextValue.getText().equalsIgnoreCase(uname)&& PasswordTextValue.getText().equals(pswd)) {
		 result=AccessDetailsInfo.getText();
		
		}
		return result;
		 
		 
	 }
	
}
