package com.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {
	
	public static Alert alert;
	
	public static void sendkeys(WebElement element, String text,WebDriver driver) {
		WebDriverWaitMethods.explicitlyWait(element, driver);
		element.sendKeys(text);
	}
	
	public static void click(WebElement element)  {
		element.click();
	}
	
	public static ArrayList<String> listToArrayList(List<WebElement> myList) {
        ArrayList<String> arl = new ArrayList<String>();
        for (WebElement object : myList) {
            arl.add((String) object.getText());
        }
        return arl;
    }
	
	public static boolean isVisible(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// To Check Element is Displayed or No.
	public static void isElementDisplayed(WebElement element) {
		boolean elementDisplayed = element.isDisplayed();
		if (elementDisplayed) {
			System.out.println("Element is Displayed");
		} else {
			System.out.println("Element is not Displayed");
		}
	}

	// To Check Element is Enabled or No.
	public static void isElementEnabled(WebElement element) {
		boolean elementEnabled = element.isEnabled();
		if (elementEnabled) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}
	}
	
	// To Handle Multiple Windows or Switch Between Multiple Windows.
	public static void switchWindow(WebDriver driver, String firstWindow, Set<String> child) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windows : windowHandles) {
			if (!windows.equals(firstWindow) && !windows.equals(child)) {
				driver.switchTo().window(windows);
			}
		}
	}
		
	// To Match Value with List of Elements and Click on it.
	public void clickOnMatchingValue(List<WebElement> listOfElements, String valueToBeMatched) {
		for (WebElement element : listOfElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
				element.click();
			}
		}
	}
	
	// To retrieve the system date
	public static String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	// To Accept Alert Pop-Up.
	public static void acceptAlertPopup(WebDriver driver) throws InterruptedException {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			System.out.println("Alert Accepted Successfully");
		} catch (Exception e) {
			System.out.println("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}

	//To Dismiss Alert Pop-Up.
	public static void dismissAlertPopup(WebDriver driver) throws InterruptedException {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println("Alert Dismissed Successfully");
		} catch (Exception e) {
			System.out.println("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}
	
	// To Switch into a Frame using Name.
	public static void switchToFrame(WebElement login_Frame,WebDriver driver) {
		try {
			driver.switchTo().frame(login_Frame);
			System.out.println("Navigated to Frame with Name ::: " + login_Frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to Locate Frame with Name ::: " + login_Frame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to Navigate to Frame with Name ::: " + login_Frame + e.getStackTrace());
		}
	}

	// To Switch into a Frame using Index.
	public void switchToFrame(int frame,WebDriver driver) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to Frame with Index ::: " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to Locate Frame with Index ::: " + frame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to Navigate to Frame with Index ::: " + frame + e.getStackTrace());
		}
	}
	public static void switchToFrame(String frameName,WebDriver driver) {
		try {
			driver.switchTo().frame(frameName);
			System.out.println("Navigated to Frame with Name ::: " + frameName);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to Locate Frame with Name ::: " + frameName + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to Navigate to Frame with Name ::: " + frameName + e.getStackTrace());
		}
	
}
}