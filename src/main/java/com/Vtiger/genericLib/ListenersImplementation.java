package com.Vtiger.genericLib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener
{

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" "+"Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" "+"Oops Test got Failed");

		try {
			BaseTest.takesScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}




}
