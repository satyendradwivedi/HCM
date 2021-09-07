package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomFields extends Base {
	
	
WebDriver ldriver;
	
	public CustomFields(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/nav/div[2]/ul[2]/li[5]/a/span")
	@CacheLookup
	WebElement setup;
	
	@FindBy(how=How.XPATH,using="/html/body/nav/div[2]/ul[2]/li[5]/ul/li[7]/a")
	@CacheLookup
	WebElement orgsetup;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[3]/div[1]/div/table/tbody/tr[1]/td/a")
	@CacheLookup
	WebElement customfield;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[3]/a")
	@CacheLookup
	WebElement newcustomfieldbutton;
	
	//New custom field page locators.
	
	@FindBy(how=How.ID,using="customFieldName")
	@CacheLookup
	WebElement cname;
	
	@FindBy(how=How.ID,using="custFieldType")
	@CacheLookup
	WebElement ctype;
	
	@FindBy(how=How.ID,using="custObjType")
	@CacheLookup
	WebElement cobjtype;
	
	@FindBy(how=How.ID,using="saveCustomButton")
	@CacheLookup
	WebElement savebutton;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[4]/div/div/div[2]/label/input")
	@CacheLookup
	WebElement search;
	
	//action methods
	
	public void setUp()
	{
		setup.click();
	}
	
	public void orgsetUp()
	{
		orgsetup.click();
	}
	public void customfieldlink()
	{
		customfield.click();
	}
	public void clickOnNewCustomButton()
	{
		newcustomfieldbutton.click();
	}
	
	public void setCName(String cnameText)
	{
		cname.sendKeys(cnameText);
	}
	
	public void customFieldType()
	{
		
		Select st = new Select(ctype);
		st.selectByVisibleText("Text Box");
	}
	
	public void customFieldTObjypeuser()
	{
		
		
		Select st1 = new Select(cobjtype);
		st1.selectByVisibleText("User Record");
	}
	
	public void customFieldTObjypeaccount()
	{
		
		
		Select st2 = new Select(cobjtype);
		st2.selectByVisibleText("Account");
	}
	public void customFieldTObjypeannouncement()
	{
		
		
		Select st3 = new Select(cobjtype);
		st3.selectByVisibleText("Announcement");
	}
	public void customFieldTObjypeasset()
	{
		
		
		Select st4 = new Select(cobjtype);
		st4.selectByVisibleText("Asset");
	}
	public void customFieldTObjypebenefits()
	{
		
		
		Select st5 = new Select(cobjtype);
		st5.selectByVisibleText("Benefits");
	}
	public void customFieldTObjypecandidate()
	{
		
		
		Select st6 = new Select(cobjtype);
		st6.selectByVisibleText("Candidate");
	}
	public void customFieldTObjypecandidateemphistory()
	{
		
		
		Select st7 = new Select(cobjtype);
		st7.selectByVisibleText("Candidate - Employment History");
	}
	public void customFieldTObjypecontact()
	{
		
		
		Select st8 = new Select(cobjtype);
		st8.selectByVisibleText("Contact");
	}
	public void saveCustom()
	{
		
		savebutton.click();
	}
	public void search(String customText)
	{
		search.sendKeys(customText);
	}


}
