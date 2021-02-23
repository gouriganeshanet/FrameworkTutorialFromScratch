package com.learningframework.TestCases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;


import com.learningframework.Utility.HelperUtility;
import com.learningframework.pages.CRMLoginPage;

public class LoginintoApplication extends TestBaseClass {
	

	
	@Test(priority=1)
	public void startBrowser()
	{
		logger=report.createTest("log into CRM");// this logger is responsible for all the logging activities in test
		
		CRMLoginPage cls =PageFactory.initElements(driver, CRMLoginPage.class);
		
		logger.info("Starting Application");
		
		cls.login(TDU.getStringData("LOGIN", 0, 0), TDU.getStringData("LOGIN", 0, 1));
		
		logger.pass("Logger in succesfully");
		
		HelperUtility.screenshotCapture(driver);
		
	}

	
}
