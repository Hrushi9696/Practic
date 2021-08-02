package com.listner;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseClass;
import com.reports.screenshotFile;


public class TestListner extends BaseClass implements ITestListener {
	
	public WebDriver driver;

	//@Override
	public void onTestStart(ITestResult result) {
	System.out.println(result.getName()+"Test is ready to execute..");
	System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ "Test is Successfully Completed..");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+"Test is failed..");
		System.out.println(new java.util.Date()+"Finish Time..");
		try {
			screenshotFile.getScreenShotPath(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+"Test is skipped..");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName()+"Test Failed but within  Success percentage...");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getName()+"Test Failed with timeout...");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+"Test Suit is ready to start");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

	//@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+"Test Suit is Finished..");
		System.out.println(new java.util.Date()+"Finish Time..");
	}

}
