package com.test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.reports.screenshotFile;



public class LoginTest extends BaseClass {

	public LoginPage lp=null;
	public WebDriver driver=null;
	public screenshotFile sf=null;
	
	@BeforeMethod(alwaysRun=true)
	public void initializeBrowser() throws IOException{
		driver=BaseClass.initializeDriver();
		lp=new LoginPage(driver);
		sf=new screenshotFile(driver);
	}
	
	@Test(priority=0,description="Verify whether the user is able to login by using valid username and password")
	public void valid_userName_and_password() throws AWTException, IOException{
		Assert.assertTrue(lp.login_to_redbus_with_valid_username_and_password(driver));	
	}
	
	@Test(priority=1,description="Verify whether the user is unable to login by using invalid username and password and check appropriate error message is displayed")
	public void invalid_userName_and_password() throws AWTException, IOException{
		Assert.assertTrue(lp.login_toredBus_with_invalid_username_and_valid_password(driver));	
	}
	
	@Test(priority=2,description="Verify whether the user is unable to login by using invalid username and valid password and check appropriate error message is displayed")
	public void invalid_userName_and_valid_password() throws AWTException, IOException{
		Assert.assertTrue(lp.login_toRedBus_with_valid_username_and_invalid_password(driver));	
	}
	
	@Test(priority=3,description="Verify whether the user is unable to login by using valid username and invalid password and check appropriate error message is displaye")
	public void valid_userName_and_invalid_password() throws AWTException, IOException{
		Assert.assertTrue(lp.login_toRedBus_with_invalid_username_and_invalid_password(driver));
	}
	
	/*@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}*/
	
	
}
