package com.utility;


import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitMethods {
	
	private WebDriver driver = null;
		
	public static void explicitlyWait(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.ignoring(NoSuchElementException.class);
	}
	
	
	public static void visibilityOfElementLocated(By element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static void elementToBeSelected(WebElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		wait.ignoring(StaleElementReferenceException.class);
	}
	
	public static void elementToBeClickable(WebElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("xpath")));
		wait.ignoring(StaleElementReferenceException.class);
	}

	public static void explicitlyWait(List<WebElement> element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		wait.ignoring(NoSuchElementException.class);
	}
		
	
}
