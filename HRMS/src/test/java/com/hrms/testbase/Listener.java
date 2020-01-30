package com.hrms.testbase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.hrms.utils.CommonMethods;

public class Listener extends BaseClass implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test STARTED "+result.getName());
		test=report.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+result.getName());
		test.pass("Test Passed "+result.getName());
		String imagePath=CommonMethods.takeScreenShot("passed/"+result.getName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed "+result.getName());
		test.fail("Test Failed "+result.getName());
		String imagePath=CommonMethods.takeScreenShot("failed/"+result.getName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}