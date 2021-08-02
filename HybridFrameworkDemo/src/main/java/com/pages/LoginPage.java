package com.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;


import com.utility.JavascriptFunctions;
import com.utility.SeleniumUtils;
import com.utility.WebDriverWaitMethods;


public class LoginPage {

	public WebDriver driver;
	public static Logger log=Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='rPool ']")
	private WebElement rpool;
	
	@FindBy(xpath="//span[text()='Offer Ride']")
	private WebElement brixPass;
	
	@FindBy(id="btn_login")
	private WebElement btnLogin;
	
	@FindBy(xpath="//span[text()='BrixLite']")
	private WebElement brixLiteApplication;
	
	@FindBy(xpath="//div[text()='Commuting within the City?']")
	private WebElement communicateCity;
	
	@FindBy(xpath="//h1")
	private WebElement userNotExist;
	
	@FindBy(id="signin-block")
	private WebElement signin;
	
	@FindBy(xpath="//li[text()='Sign In/Sign Up']")
	private WebElement sign_up;
	
	@FindBy(xpath="//iframe[contains(@src,'login')]")
	private WebElement login_Frame;
	
	@FindBy(xpath="//div[text()='Facebook']")
	private WebElement fb;
	
	@FindBy(xpath="//input[@placeholder='Enter your mobile number']")
	private WebElement phone;
	
	@FindBy(xpath="//a[@href='/info/redcare']")
	private WebElement helpclick;
	
	@FindBy(xpath="//iframe[@class]")
	private WebElement help_Frame;
	

	@FindBy(xpath="//input[@id='mobileNoInp']")
	private WebElement helpPhone;
	
	public void login_to_brixLite(WebDriver driver){
		/*brixUsername.sendKeys(ReadPropertyFile.get("username"));
		brixPass.sendKeys(ReadPropertyFile.get("password"));
		btnLogin.click();
		brixLiteApplication.click();
	*/
		JavascriptFunctions.jsClick(driver, rpool);
	}
	public boolean login_to_redbus_with_valid_username_and_password(WebDriver driver){
		JavascriptFunctions.jsClick(driver, rpool);
		//btnLogin.click();
		WebDriverWaitMethods.explicitlyWait(communicateCity, driver);
		String acttitle=communicateCity.getText();
		if(acttitle.equals("Commuting within the City?")){
			return true;
		}else{
			return false;
		}
	}

	public boolean login_toredBus_with_invalid_username_and_valid_password(WebDriver driver) {
		JavascriptFunctions.jsClick(driver, signin);
		JavascriptFunctions.jsClick(driver, sign_up);
		SeleniumUtils.switchToFrame(login_Frame, driver);
		WebDriverWaitMethods.elementToBeClickable(fb, driver);
		
		
			return true;
		
	}

	public boolean login_toRedBus_with_valid_username_and_invalid_password(WebDriver driver) {
		JavascriptFunctions.jsClick(driver, helpclick);
		String Parent=driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();
		SeleniumUtils.switchWindow(driver, Parent, child);
		SeleniumUtils.switchToFrame(help_Frame, driver);
		helpPhone.sendKeys("9511834138");
		
		return true;
	}

	public boolean login_toRedBus_with_invalid_username_and_invalid_password(WebDriver driver) {
		login_Frame.sendKeys("superuse");
		brixPass.sendKeys("secre");
		JavascriptFunctions.jsClick(driver, btnLogin);
		//btnLogin.click();
		WebDriverWaitMethods.explicitlyWait(userNotExist, driver);
		String errorMsg=userNotExist.getText();
		if(errorMsg.equals("HTTP Status 500 -")){
			return true;
		}else{
			return false;
		}	
	}
}
