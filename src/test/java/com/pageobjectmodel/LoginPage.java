package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="email")
	WebElement emailid;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id="btnLogin")
	WebElement login;
	
	
	public void setEmail(String emailtext)
	
	{
		emailid.sendKeys(emailtext);
	}
	
    public void setPassword(String passtext)
	
	{
		pass.sendKeys(passtext);
	}
	
	public void clickLogin()
	
	{
		login.click();
	}
	
	
}
