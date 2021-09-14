package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageobjectmodel.Base;
import com.pageobjectmodel.Location;
import com.pageobjectmodel.LoginPage;

public class LocationTest extends Base{

	SoftAssert s_assert;
	Location lc;
	@Test(priority=1, description="Title of the Location Page")
	
	public void gettitleLocation() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail(emailid);
		logger.info("Entering username");
		Thread.sleep(4000);
		lp1.setPassword(password);
		logger.info("Entering password");
		Thread.sleep(4000);
		lp1.clickLogin();
		Thread.sleep(4000);
		lc=new Location(driver);
		Thread.sleep(4000);
		lc.setup();
		logger.info("Accessing Setup Module");
		lc.orgsetup();
		logger.info("Org Setup Module");
		lc.orgdetails();
		logger.info("Org Details");
		lc.locations();
	    
	if(driver.getTitle().equalsIgnoreCase("Company Locations"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"gettitlelocation");
		Assert.assertFalse(true);
	}
				
}
@Test(priority=2, description="Validation message for mandatory data")
	
	public void valLocation() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		lc.newlocation();
		lc.save();
		logger.info("Clicking on Save Location button");
		String val="Please fill out this field.";
		Assert.assertEquals(val, "Please fill out this field.");
		logger.info("Validation message for mandatory fields");
		
    }
@Test(priority=3, description="Creating a new location")

public void newlocation() throws InterruptedException, IOException
{
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
	logger.info("Enter all the mandatory information..");
	lc.locationname("Noida");
	Thread.sleep(4000);
	lc.locationdesc("Noida Sector 61");
	Thread.sleep(4000);
	lc.locationcode("AM");
	Thread.sleep(4000);
	lc.ladderss("Noida");
	Thread.sleep(4000);
	lc.lcity("Noida");
	Thread.sleep(4000);
	lc.lstate("U.P");
	Thread.sleep(4000);
	lc.lcountry("India");
	Thread.sleep(4000);
	lc.lzipcode("500038");
	lc.save();
	logger.info("New Location has been creates");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input")).sendKeys("Noida Sector 61");
	String loc=driver.findElement(By.xpath("//a[contains(text(),'Noida Sector 61')]")).getText();
	System.out.println(loc);
	
	if(driver.findElement(By.xpath("//a[contains(text(),'Noida Sector 61')]")).getText().equalsIgnoreCase("Noida Sector 61"))
	{
	    Assert.assertTrue(true);
	}
	
	else
	{
		captureScreen(driver,"newlocation");
		Assert.assertFalse(true);
	}
}
	@Test(priority=4, description="Updating existing Location")

	public void updatelocation() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Noida Sector 61')]")).click();
		Thread.sleep(4000);
		logger.info("Open existing location");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='locationName']")).clear();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='locationName']")).sendKeys("Noida Sector 71");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/form/div[8]/button")).click();
		logger.info("Updated existing location");
		
		
		
		
		if(driver.findElement(By.xpath("//a[contains(text(),'IT Hub')]")).getText().equalsIgnoreCase("Noida Sector 71"))
		{
		    Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver,"updatelocation");
			Assert.assertFalse(true);
		}
	
	
}
}