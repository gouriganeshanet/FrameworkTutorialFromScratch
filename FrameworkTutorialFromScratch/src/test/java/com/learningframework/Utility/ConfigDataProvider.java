package com.learningframework.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	
	public  ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("Unable to read the Properties file"+e.getMessage());
		}
		
		
	}
	
	
	public String  getDataFromConfig(String KeyToSearch)
	{
		return prop.getProperty(KeyToSearch);
	}

	public String getBrowserDatafromConfig()
	{
		return prop.getProperty("Browser");
	}
	
	public String  getStagingUrlFromConfig()
	{
		return prop.getProperty("qaURL");
	}
	

}
