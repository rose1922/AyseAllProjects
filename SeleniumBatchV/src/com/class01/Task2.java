package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/* TC 2: Syntax Page URL Verification: 
Open chrome browser
Navigate to “https://www.syntaxtechs.com/”
Navigate to “https://www.google.com/”
Navigate back to Syntax Technologies Page
Refresh current page
Verify url contains “Syntax”*/
public class Task2 {
	public static void main(String[] args) throws InterruptedException {
		// key Value
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.syntaxtechs.com/");
		
		
		driver.navigate().to("https//www.google.com/");
	
		
		driver.navigate().back();
		
		
		driver.navigate().refresh();
		
		String currentURL=driver.getCurrentUrl();
		if(currentURL.contains("syntax")) {
			System.out.println("the URL contains\"syntax\"");
		}    else { 
			System.out.println("the URL does not contains\"syntax\"");
				
			}
		driver.close();
		}

}

