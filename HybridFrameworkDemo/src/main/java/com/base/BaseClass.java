package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.reports.Extentreport;
import com.utility.Constants;

public class BaseClass extends  Extentreport{
	public static WebDriver driver;
	public static WebDriver initializeDriver(){
		
		//WebDriver driver=BrowerFactory.browserInstance(ReadPropertyFile.get("url"));
		WebDriver driver=BrowerFactory.browserInstance(ReadPropertyFile.get("browser"));
		driver.get(ReadPropertyFile.get("url"));
		DriverManager.setWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		return driver;
		
		
		
		
		
	}
	
	
	
}
