package com.learningframework.TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learningframework.Utility.BrowserFactory;
import com.learningframework.Utility.ConfigDataProvider;
import com.learningframework.Utility.HelperUtility;
import com.learningframework.Utility.TestDataUtility;

public class TestBaseClass {
	
	public  WebDriver driver;
	public   TestDataUtility TDU;
	public   ConfigDataProvider config;
	ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public  void setupSuite()
	{
		Reporter.log("Setting up Reports and Test is getting ready ",true );
		TDU = new TestDataUtility();
		config = new ConfigDataProvider();
		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./Reports/FreeCRMreport"+HelperUtility.getcurrentDateTime() + ".html"));
		report= new ExtentReports();
		report.attachReporter(reporter);
		
		Reporter.log("Setting up is complete ", true);
	}
	
	
	
	
	
	
	@BeforeClass
	public void  browserStartup()
	
	{
		Reporter.log("Browser is getting ready to started", true);
		driver =BrowserFactory.startApplication( driver, config.getBrowserDatafromConfig(), config.getStagingUrlFromConfig());
		//System.out.println(driver.getTitle());
		
		Reporter.log("Browser is started ", true);
	}
	
	
	@AfterMethod // after method is very helpfull, to run this method after every test case, if 50 tc, keep inside the after methods
	public void teardownScreenshot(ITestResult result) throws IOException
	{
		Reporter.log("Application is getting ready to teardown", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
				logger.fail("TestFailed ", MediaEntityBuilder.createScreenCaptureFromPath(HelperUtility.screenshotCapture(driver)).build());
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
			{
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperUtility.screenshotCapture(driver)).build());
			}
							
		else if (result.getStatus()== ITestResult.SKIP)
			{
				logger.skip("Test Case Skipped", MediaEntityBuilder.createScreenCaptureFromPath(HelperUtility.screenshotCapture(driver)).build());
			}
				
			
		
		report.flush();// this will keep adding , meaning , if you are having 5 tc, its going to add to make it as single report
		
		Reporter.log("Report is getting ready based on the test cases", true);
		
	}
	
	
	@AfterClass
	public  void teardown()
	{
		
		//HelperUtility.screenshotCapture(driver);
		BrowserFactory.quitBrowser(driver);
	}
	
	
	

}
