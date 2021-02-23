package com.learningframework.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String Browser1, String URL)
	{
		if(Browser1.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		else if(Browser1.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(Browser1.equals("IE"))
		{
			System.setProperty("webdriver.gecko", "./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		return driver;
	}
	
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
}
