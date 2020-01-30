package com.class01;

import org.testng.annotations.*;

public class Class01_Task2 {

	/* Create class that will have:
	Before and After Class annotation
	Before and After Method annotation
	2 methods with Test annotation
	 */
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {		
		System.out.println("AfterMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2(){
		System.out.println("Test 2");
	}
}