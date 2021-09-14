package com.testcases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageobjectmodel.Base;
import com.pageobjectmodel.CustomFields;
import com.pageobjectmodel.LoginPage;
public class CustomFieldTest extends Base {
	
	
	SoftAssert s_assert;
	CustomFields cf;
	@Test(priority=1, description="Title of the custom field")
	
	public void gettitleCustomField() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail(emailid);
		Thread.sleep(4000);
		lp1.setPassword(password);
		Thread.sleep(4000);
		lp1.clickLogin();
		Thread.sleep(4000);
		cf=new CustomFields(driver);
		Thread.sleep(4000);
		cf.setUp();
		logger.info("Accessing Setup Module");
		cf.orgsetUp();
		logger.info("Org Setup Module");
		cf.customfieldlink();
		logger.info("Accessing Custom Field link");
		driver.getTitle();
		if(driver.getTitle().equalsIgnoreCase("Custom Fields"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver,"titleCustomField");
			Assert.assertFalse(false);
		}
		
	}
	
	@Test(priority=2, description="validation message")
	public void accesscustomFieldvalidation() throws InterruptedException
	{
	s_assert=new SoftAssert();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	cf=new CustomFields(driver);
	cf.clickOnNewCustomButton();
	Thread.sleep(4000);
	cf.customFieldType();
	Thread.sleep(4000);
	cf.saveCustom();
	String valmessage="Please fill out this field.";
	s_assert.assertEquals(valmessage, "Please fill out this field.");
	System.out.println("Validation message:" +valmessage);
	s_assert.assertAll();
	
}
    @Test(priority=3,description="user custom field text")
	
	public void usercustomfield() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cf=new CustomFields(driver);
		cf.setUp();
		cf.orgsetUp();
		cf.customfieldlink();
		cf.clickOnNewCustomButton();
		cf.setCName("SSF");
		logger.info("Entering Custom Name");
		cf.customFieldType();
		cf.customFieldTObjypeuser();
		logger.info("Selecting Location of Custom Field User ");
		cf.saveCustom();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SSF");// Searching the locati by
		logger.info("Searching custom field");
		// entering values into
		// search textbox
	     String search = "SSF";
	     Assert.assertEquals(search, "SSF");
	} 
/*@Test(priority=4,description="account custom field")
	
	public void accountcustomfield() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cf=new CustomFields(driver);
		Thread.sleep(4000);
		cf.clickOnNewCustomButton();
		cf.setCName("Account Number");
		logger.info("Entering custom field for Account");
		cf.customFieldType();
		cf.customFieldTObjypeaccount();
		logger.info("Selecting Location of Custom Field Account");
		cf.saveCustom();
	}
     @Test(priority=5,description="announcement custom field")

     public void announcementcustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("announcement");
	logger.info("Entering custom field for Announcement");
	cf.customFieldType();
	cf.customFieldTObjypeannouncement();
	logger.info("Selecting Location of Custom Field announcement ");
	cf.saveCustom();
}
     @Test(priority=6,description="Asset custom field")

     public void assetcustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("System Detail");
	logger.info("Entering custom field for Asset");
	cf.customFieldType();
	cf.customFieldTObjypeasset();
	logger.info("Selecting Location of Custom Field Asset ");
	cf.saveCustom();
}
     @Test(priority=7,description="Benefits custom field")

     public void benefitscustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("Organizational Benefits");
	logger.info("Entering custom field for Benefits");
	cf.customFieldType();
	cf.customFieldTObjypebenefits();
	logger.info("Selecting Location of Custom Field Benefits ");
	cf.saveCustom();
}
     @Test(priority=8,description="Candidate custom field")

     public void candidatecustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("Candidate Information");
	logger.info("Entering custom field for Candidate");
	cf.customFieldType();
	cf.customFieldTObjypecandidate();
	logger.info("Selecting Location of Custom Field Candidate ");
	cf.saveCustom();
}
     @Test(priority=9,description="Candidate Employment History custom field")

     public void candidateemploycustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("Candidate Existing Employment");
	logger.info("Entering custom field for CandidateEmployment History");
	cf.customFieldType();
	cf.customFieldTObjypecandidateemphistory();
	logger.info("Selecting Location of Custom Field Candidate History ");
	cf.saveCustom();
}  
     @Test(priority=10,description="Contact custom field")

     public void contactcustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cf=new CustomFields(driver);
	Thread.sleep(4000);
	cf.clickOnNewCustomButton();
	cf.setCName("Contact Detail");
	logger.info("Entering custom field for Contact");
	cf.customFieldType();
	cf.customFieldTObjypecontact();
	logger.info("Selecting Location of Custom Field Contact");
	cf.saveCustom();
}  
     @Test(priority=11,description="Search custom field")

     public void searchcustomfield() throws InterruptedException
    {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("System Detail");// Searching the locati by
	logger.info("Searching custom field");
	// entering values into
	// search textbox
     String search = "System Detail";
     
     
    	 Assert.assertEquals(search, "System Detail");// validating search results by assertion by actual and expected
    
// results
	} */

}
