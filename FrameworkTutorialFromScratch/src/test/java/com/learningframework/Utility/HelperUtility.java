package com.learningframework.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;




public class HelperUtility {
	
	// here we are going to add different libraries, that is to enhance the script
	
	
	public static String screenshotCapture(WebDriver driver)
	{
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// this will return as File type and then file into a location
	
	 String screenshotPath = System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getcurrentDateTime()+".png";
	 
	 try {
		FileHandler.copy(src, new File(screenshotPath));
	 	System.out.println("Screen shot captured successfully");
	 
	 	}
	 
	 	catch (Exception e) {
		 System.out.println("Unable to catch the screen shots"+e.getMessage());
	 	}
		return screenshotPath;
	}


	public static String  getcurrentDateTime()
	{
		DateFormat customdateformat = new  SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date currentdate = new Date();
		return customdateformat.format(currentdate);
		
		
	}
	
	
	
}
