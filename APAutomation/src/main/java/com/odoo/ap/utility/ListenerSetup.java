package com.odoo.ap.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase execution started :- "+result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase execution passed :- "+result.getName());	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utils.captureScreenshot(result.getName());
		System.out.println("Testcase execution failed :- "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase execution skipped :- "+result.getName());	
	}

	
}
