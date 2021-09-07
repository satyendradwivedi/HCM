package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserView extends Base{
WebDriver ldriver;
	
	public UserView(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="/html/body/nav/div[2]/ul[2]/li[6]/a")
	WebElement user;
	
	@FindBy(xpath="//li[@id='documentsTab']")
	WebElement doc;
	
	@FindBy(xpath="//a[@href='#tasks']")
	WebElement workflow;
	
	@FindBy(xpath="//*[@id=\"ptoListTab\"]")
	WebElement leave;
	
	@FindBy(xpath="//*[@id=\"goalListTab\"]")
	WebElement goal;
	
	@FindBy(xpath="//*[@id=\"feedbackListTab\"]")
	WebElement feedback;
	
	@FindBy(xpath="//*[@id=\"appraisalListTab\"]")
	WebElement reviews;
	
	@FindBy(xpath="//*[@id=\"skillsListTab\"]")
	WebElement skill;
	
	@FindBy(xpath="//*[@id=\"trainingListTab\"]")
	WebElement training;
	
	@FindBy(xpath="//*[@id=\"projectListTab\"]")
	WebElement project;
	
	@FindBy(xpath="//*[@id=\"assetsListTab\"]")
	WebElement asset;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[4]/div[1]/div[1]/ul/li[12]/a")
	WebElement finan;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[4]/div[1]/div[1]/ul/li[14]/a")
	WebElement form;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[3]/div/div[1]/ul/li[15]/a")
	WebElement history;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[4]/div[1]/div[1]/ul/li[16]/a")
	WebElement admin;
	

	public void clickuser()
	
	{
		user.click();
	}
	
    public void clickDoc()
    {
    	doc.click();
    	
    	
    }
	
    public void clickWorkflow()
    {
    	workflow.click();
    }
    public void clickLeave()
    {
    	leave.click();
    }
	
    public void clickGoal()
    {
    	goal.click();
    }
    
    public void clickFeedback()
    {
    	feedback.click();
    }
    
    public void clickReview()
    {
    	reviews.click();
    }
    public void clickSkill()
    {
    	skill.click();
    }
    public void clickTraining()
    {
    	training.click();
    }
    public void clickProject()
    {
    	project.click();
    }
    public void clickAsset()
    {
    	asset.click();
    }
    public void clickFinancial()
    {
    	finan.click();
    }
    
    public void clickForm()
    {
    	form.click();
    }
    public void clickHistory()
    {
    	history.click();
    }
    public void clickAdmin()
    {
    	admin.click();
    }
}
