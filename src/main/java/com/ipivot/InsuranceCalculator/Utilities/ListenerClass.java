package com.ipivot.InsuranceCalculator.Utilities;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;



//ITESTListener is an interface which we need to implement
public class ListenerClass implements ITestListener {
	Logger log = Logger.getLogger(ListenerClass.class.getName());
	
	public void onStart(ITestResult result) {
		log.info("Test Started" + result.getTestName().toString());
	}
	
	public void onFinish(ITestResult result) {
	
		log.info("Test Finished" + result.getTestName().toString());
	}
	
	public void onTestSuccess(ITestResult result) {
		log.info("Test execution is Passed for testCase" + result.getTestName().toString());
	}
	

	public void onTestStart(ITestResult result) {
		log.info("Test execution is started for testCase"+result.getInstanceName() );
	}
}
