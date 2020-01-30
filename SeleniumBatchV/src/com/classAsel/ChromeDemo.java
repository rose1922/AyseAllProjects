package com.classAsel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {
	
	public static void main(String[] args) {
  //Why?
 //1.WebDriver driver=new WebDriver();
 //WebDriver is an interface,we cannot create an obj of an interface
		
	// 2.
		
	// ChromeDriver driver=new ChromeDriver();
	// FirefoxDriver driver1=new FireFoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
				
	 
	 
		WebDriver driver=new ChromeDriver();
		
		//open google page
		driver.get("https://google.com");
		
		
		
		
		
	}

}
