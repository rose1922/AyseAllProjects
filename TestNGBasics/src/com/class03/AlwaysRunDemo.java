package com.class03;

import org.testng.annotations.*;

import com.utils.CommonMethods;

public class AlwaysRunDemo extends CommonMethods{

	@BeforeSuite (alwaysRun=true)
	public void beforeSuite() {
		System.out.println("I am before suite");
	}
	
	@AfterSuite (alwaysRun=true)
	public void afterSuite() {
		System.out.println("I am after suite");
	}
	
	@BeforeTest (alwaysRun=true)
	public void beforeTest() {
		System.out.println("I am before test");
	}
	
	@AfterTest (alwaysRun=true)
	public void afterTest() {
		System.out.println("I am after test");
	}
	
	@BeforeClass (alwaysRun=true)
	public void beforeClass() {
		System.out.println("I am before class");
	}
	
	@AfterClass (alwaysRun=true)
	public void afterClass() {
		System.out.println("I am after class");
	}
	
	@BeforeMethod (alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	@AfterMethod (alwaysRun=true)
	public void afterMethod() {
		System.out.println("I am after method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("I am test method-1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("I am test method-2");
	}
}
