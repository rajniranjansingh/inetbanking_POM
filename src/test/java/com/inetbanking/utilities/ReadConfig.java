package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations//config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception a)
		{
			System.out.println("Exception is : " + a.getMessage());
		}
		
	}

	public String getApplicationURL()
	{
		String url = pro.getProperty("BaseURL");
		return url;
	}
	
	public String getUserName()
	{
		String uname = pro.getProperty("Uname");
		return uname;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("Password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("ChromeDriverPath");
		return chromepath;
	}
	
	public String getGeckoPath()
	{
		String geckopath = pro.getProperty("GeckoDriverPath");
		return geckopath;
	}
}
