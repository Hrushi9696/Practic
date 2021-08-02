package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptFunctions {
	
	public static JavascriptExecutor js;
	
	// To Click on WebElement using JavaScript Executor.
	public static void jsClick(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// To Scroll Down upto the element using JavaScript Executor.
	public static void jsScrollIntoView(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// To Scroll Down full page using JavaScript Executor.
	public static void jsScrollDownFullPage(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// To Select Calendar Date Or Data Picker using Java Script Executor.
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);
	}

	// To Draw a Border for WebElement using JavaScript Executor.
	public static void drawElementBorderByJavaScript(WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// To Change Color of WebElement using JavaScript Executor.
	public static void changeColorByJavaScript(String color, WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// To Highlight WebElement using JavaScript Executor.
	public static void highlightElementByJavaScript(WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		String backgroundColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColorByJavaScript("rgb(0, 200, 0)", element, driver);
			changeColorByJavaScript(backgroundColor, element, driver);
		}
	}
	
	// To open new tab in running script with new url in browser using JavaScript Executor.
	public static void openNewTabByJavaScript(WebDriver driver, String url) throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.open('"+url+"');");
	    Thread.sleep(100);
	}
}
