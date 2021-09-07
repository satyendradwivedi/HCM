package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Location extends Base {
	
WebDriver ldriver;
	
	public Location(WebDriver rdriver)
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
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[2]/ul/li[2]/a")
	@CacheLookup
	WebElement orgdetails;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[3]/div[2]/div/form/table/tbody/tr[3]/td/a")
	@CacheLookup
	WebElement locations;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[3]/div[1]/a[1]")
	@CacheLookup
	WebElement newlocationbutton;
	
	@FindBy(how=How.ID,using="locationName")
	@CacheLookup
	WebElement locationname;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"locationDescription\"]")
	@CacheLookup
	WebElement desc;
	
	@FindBy(how=How.ID,using="locationCode")
	@CacheLookup
	WebElement locationcode;
	
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[2]/form/div[4]/input")
	@CacheLookup
	WebElement address1;
	
	@FindBy(how=How.ID,using="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.ID,using="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(how=How.ID,using="countryId")
	@CacheLookup
	WebElement country;
	
	@FindBy(how=How.XPATH,using="//input[@name='addressModelList[0].zipCode']")
	@CacheLookup
	WebElement zipcode;
	
	@FindBy(how=How.XPATH,using="/html/body/div[6]/div/div/div[2]/form/div[8]/button")
	@CacheLookup
	WebElement save;
	
	
	//performing the action on identified web elements
	public void setup()
	{
		setup.click();
	}
	public void orgsetup()
	
	{
		orgsetup.click();
	}
	
	public void orgdetails()
	{
		orgdetails.click();
	}
	public void locations()
	{
		locations.click();
	}
	
	public void newlocation()
	{
		newlocationbutton.click();
		
	}
	
	public void locationname(String lname)
	{
		locationname.sendKeys(lname);
	}
	
	public void locationdesc(String ldesc)
	{
		desc.sendKeys(ldesc);
	}
	
	public void locationcode(String lcode)
	{
		locationcode.sendKeys(lcode);
		
	}
	
	public void ladderss(String laddress)
	{
		address1.sendKeys(laddress);
	}
	public void lcity(String lcity)
	{
		city.sendKeys(lcity);
	}
	
	public void lstate(String lstate)
	{
		state.sendKeys(lstate);
	}
	
	public void lcountry(String lcountry)
	{
		Select st = new Select(country);
		st.selectByVisibleText(lcountry);
	}
	
	public void lzipcode(String lzipcode)
	
	{
		zipcode.sendKeys(lzipcode);
	}
	
	public void save()
	{
		save.click();
	}
	
	

}
