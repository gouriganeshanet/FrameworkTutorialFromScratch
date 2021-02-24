package com.learningframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CRMLoginPage {

	WebDriver driver;
	
	 public CRMLoginPage(WebDriver ldriver)// this constructor will help us initiate the webdriver, where we pass Webdrive as a reference // ldriver come from the main test cases
	 {
		 this.driver = ldriver;
	 }
	
	 @FindBy(name = "email") WebElement userenteringname;
	 @FindBy(name = "password") WebElement userenteringpassword;
	 @FindBy(xpath = "//div[contains(text(), \"Login\")]") WebElement loginButton;
	 
	 
	 public void login(String uname, String pwd)
	 {
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		 
		 userenteringname.sendKeys(uname);
		 userenteringpassword.sendKeys(pwd);
		 loginButton.click();
	 }
	 
	 
}
