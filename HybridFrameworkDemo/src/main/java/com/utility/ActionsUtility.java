package com.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {

	public static Actions actions;
	
		//To Click on Element using Actions Class.
		public void clickOnElementUsingActions(WebDriver driver,WebElement element) 
		{
			actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
			
		//To Mouse Hover and Click or Select an Element using Actions Class.
		public static void moveToElement(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		}

		//To Perform Drag and Drop action using Actions Class - 1.
		public static void dragAndDrop_1(WebDriver driver, WebElement sourceElement, WebElement destinationElement) 
		{
			actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
		}

		//To Perform Drag and Drop action using Actions Class - 2.
		public static void dragAndDrop_2(WebDriver driver, WebElement sourceElement, WebElement destinationElement) 
		{
			actions = new Actions(driver);
			actions.clickAndHold(sourceElement).pause(Duration.ofSeconds(2)).moveToElement(destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
		}

		//To Perform Right Click action using Actions Class.
		public static void rightClick(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.contextClick(element).build().perform();
		}

		//To perform Double Click action using Actions Class.
		public static void doubleClick(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.doubleClick(element).build().perform();
		}

}
