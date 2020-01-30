package com.class01;

import org.testng.annotations.*;

public class DifferentAnnatotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void method1() {
		System.out.println("Application of the method 1");
	}
	
	@Test
	public void method2() {
		System.out.println("Application of the method 2");
	}
	
}