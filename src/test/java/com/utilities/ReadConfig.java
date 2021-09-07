package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	private Properties pro;

	public ReadConfig() {
	File src = new File("./Configuration/config.properties");
	try {
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
	} catch (Exception e) {
	System.out.println("Exception is" +e.getMessage());
	}
	}
	
	public String getUrl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getEmail()
	{
		String email=pro.getProperty("emailid");
		return email;
	}
	public String getPassword()
	{
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getChrome()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String getFirefoxpath()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
}
