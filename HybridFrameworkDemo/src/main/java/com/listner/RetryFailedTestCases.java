package com.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*Create a custom class that implements IRetryAnalyzer interface.

Override the public boolean retry 

Make this method to return true, if you want to retry else return false.

Use @Test(retryAnalyzer=CustomRetryListener.class) with test method

Other approach to use testng.xml
*/



public class RetryFailedTestCases implements IRetryAnalyzer {

	/*
	 * retryCount
	 * MAX_RETRY_COUNT
	 * */

	private int count=0;
	private final int maxLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (count<maxLimit) {
			count++;
			return true;
		}
		else 
		{
			return false;
		}
	}
}
