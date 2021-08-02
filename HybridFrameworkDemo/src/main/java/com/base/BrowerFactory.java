package com.base;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utility.Constants;

public class BrowerFactory {

	
	
	

		public static WebDriver browserInstance(String browser){
			WebDriver driver = null;
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.addArguments("--disable-infobars");
				options.addArguments("--start-maximized");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--disable-popup-blocking");
				driver = new ChromeDriver(options);
				
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVERPATH);
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--disable-infobars");
				options.addArguments("--start-maximized");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--disable-popup-blocking");
				driver = new FirefoxDriver(options);
			} else if (browser.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			return driver;
		}
}
