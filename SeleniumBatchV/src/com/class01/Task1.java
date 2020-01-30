package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
//	TC 1: Amazon Page Title Verification:
//	Open chrome browser
//	Go to “https://www.amazon.com/”
//	Verify Title “Amazon.com: Online Shopping for Electronics, 
//	Apparel, Computers, Books, DVDs & more” is displayed
	
	
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("http://google.com");
//		
//		Thread.sleep(1000);
//		
//		driver.navigate().to("https://www.amazon.com/");
//		
//		String actualTitle = driver.getTitle();
//		System.out.println(actualTitle);
//		//driver.close();
		
		
		
		System.out.println("--------2. yol--------");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
			WebDriver dr = new ChromeDriver();
		     
		  dr.get("https://www.amazon.com/");
		     
		   
		    String title=dr.getTitle();
		     
		    if(title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
		      System.out.println("Title matches expected title");
		    }else {
		      System.err.println("Titl edoes not matches expected title");
		    }	      
		  // dr.close();
	
	}
}