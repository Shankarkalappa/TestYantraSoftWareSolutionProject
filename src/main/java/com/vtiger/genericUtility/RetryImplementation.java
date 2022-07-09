package com.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {

	int count=0;
	int maxLimit = 1;
	public boolean retry(ITestResult result) {

		while (count< maxLimit) {
			count++;
			return true;
		}
		return false;
	}

}
