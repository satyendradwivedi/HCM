package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjectmodel.Base;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.UserView;

public class LoginTest001 extends Base
{
	
	UserView uv;
	@Test(priority=1,description="Validation message for Manadatory Fields")
	public void validationmessage() throws InterruptedException, IOException
	{
		
		//logger.info("Opening the application");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(4000);
		lp.clickLogin();
		WebElement emailvalidation=driver.findElement(By.xpath("//span[contains(text(),'Email is required.')]"));
		logger.info("Entering the email id");
		emailvalidation.getText();
		WebElement passvalidation=driver.findElement(By.xpath("//span[contains(text(),'Password is required.')]"));
		logger.info("Entering the password");
		passvalidation.getText();
		
		if(emailvalidation.getText().equalsIgnoreCase("Email is required.") && passvalidation.getText().equalsIgnoreCase("Password is required.")) {
			
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver,"validationmessage");
			Assert.assertTrue(false);
			Thread.sleep(4000);
		}
		
	}
	@Test(priority=2, description="Validation message for Invalid credentials")
	public void validationInvalidCred() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail("xwx");
		logger.info("Entering the invalid email id");
		Thread.sleep(4000);
		lp1.setPassword("xxx");
		logger.info("Entering the invalid password");
		Thread.sleep(4000);
		lp1.clickLogin();
		driver.findElement(By.id("email")).clear();
		logger.info("Clearing the invalid email id");
		driver.findElement(By.id("password")).clear();
		logger.info("Clearing the invalid password");
		Thread.sleep(4000);
	String val=	driver.findElement(By.xpath("/html/body/div[2]/form/div/div[1]/div/p")).getText();
	System.out.println(val);
		
		if(val.equals("Invalid credentials."))
		{
			Assert.assertTrue(true);
			logger.info("Verifying validation message");
			Thread.sleep(4000);
		}
		
		else
		{
			captureScreen(driver,"validationInvalidCred");
			Assert.assertTrue(false);
			Thread.sleep(4000);
		}
	}
	@Test(priority=3, description="Login sucessfully")
	public void loginapp() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail(emailid);
		logger.info("Entering the email id");
		Thread.sleep(4000);
		lp1.setPassword(password);
		logger.info("Entering the Password");
		Thread.sleep(4000);
		lp1.clickLogin();
		Thread.sleep(4000);
		String title=driver.getTitle();
		Thread.sleep(8000);
		System.out.println(title);
		Thread.sleep(8000);
		
		if(driver.getTitle().equals("BizMerlin Home"))
		{
			Assert.assertTrue(true);
			logger.info("Verifying the Dashboard Home Page Title");
			Thread.sleep(4000);
		}
		
		else
		{
			captureScreen(driver,"loginapp");
			Assert.assertTrue(false);
			Thread.sleep(4000);
		}
	}
}
	
	
	

