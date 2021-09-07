package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageobjectmodel.Base;
import com.pageobjectmodel.CustomFields;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.UserView;

public class UserViewTest extends Base {

	SoftAssert s_assert;
	UserView uv;
	@Test(priority=1, description="Accessing the user view screen")
	
	public void getuserview() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail(emailid);
		Thread.sleep(4000);
		lp1.setPassword(password);
		Thread.sleep(4000);
		lp1.clickLogin();
		uv=new UserView(driver);
		uv.clickuser();
	}
		
	
}
