package com.pageobjectmodel;


import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static Logger logger;
	ReadConfig rcg=new ReadConfig();
	
	public String baseUrl=rcg.getUrl();
	public String emailid=rcg.getEmail();
	public String password=rcg.getPassword();
	
	@Parameters("browsers")
	@BeforeClass
	public void setUp(String br) throws InterruptedException,IOException
	{
		
		logger=Logger.getLogger("HCM");
	
		PropertyConfigurator.configure("Configuration//log4j.properties");
		
		if(br.equals("chrome"))
		{    //Jenkins Linux configuration
			/*System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("/usr/bin/google-chrome");  //chrome binary location specified here
			opt.addArguments("--headless");
			opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			opt.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(opt);
			driver.get(baseUrl);*/
			//local system configuration
		System.setProperty("webdriver.chrome.driver", rcg.getChrome());
		WebDriverManager.chromedriver().setup();
		
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("Launching the browser");
		driver.get(baseUrl);
		logger.info("Launching the application");
		}
		else
			if(br.equals("firefox"))
			{
			//System.setProperty("webdriver.gecko.driver", rcg.getFirefoxpath());
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Thread.sleep(5000);	
			logger.info("Launching the browser");
			driver.get(baseUrl);
			logger.info("Launching the application");
			}
		
			
		
	}
	
	
   @AfterClass
   public void tearDown()
   {
	   driver.quit();
   }
   
   public void captureScreen(WebDriver driver,String tname) throws IOException
   {
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
	   File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname+ ".png");
	   FileUtils.copyFile(source, target);
	   System.out.println("Screenshots is taken");
	   
   }
}
