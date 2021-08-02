package com.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	
	public static WebDriver driver;

	//To Select a value from Drop Down by using SelectByValue Method.
	public static void selectValueFromDropDownByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	//To Select a value from Drop Down by using SelectByIndex Method.
	public static void selectValueFromDropDownByIndex(WebElement element, int index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}

	//To Select a value from Drop Down by using SelectByVisibleText Method.
	public static void selectValueFromDropDownByText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select se = new Select(element);
		List<WebElement> selectedall = se.getAllSelectedOptions();
		return selectedall;
	}
	
	//To Print all Values and Select a Required Value from Drop Down.
	public static void selectDropDownValue(String xpathValue, String value) {
		List<WebElement> dropDownList = driver.findElements(By.xpath(xpathValue));
		System.out.println(dropDownList.size());

		for (int i = 0; i < dropDownList.size(); i++) {
			System.out.println(dropDownList.get(i).getText());
			if (dropDownList.get(i).getText().equals(value)) {
				dropDownList.get(i).click();
				break;
			}
		}
	 }
	
	//To Validate Drop Down Values.
	public static List<String> dropDownValuesValidation(WebElement element) {
		Select select = new Select(element);
		List<WebElement> dropDownValues = select.getOptions();
		List<String> toolsDropDownValues = new ArrayList<String>();

		for (WebElement listOfDropDownValues : dropDownValues) {
			toolsDropDownValues.add(listOfDropDownValues.getText());
		}
		return toolsDropDownValues;
	}
	
	
}
