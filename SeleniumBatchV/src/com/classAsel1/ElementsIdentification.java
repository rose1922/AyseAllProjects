package com.classAsel1;

import org.openqa.selenium.WebDriver;//cont shift o ile
import org.openqa.selenium.chrome.ChromeDriver;// cont shift o ile

public class ElementsIdentification {

	public static void main(String[] args) {
		/*
		 * functional testing automation tools:QTP/UFT,Selenium,SoapUI
		 * non functional testing automation tools:loadRunner,JMeter
		 * Advantages of Selenium webDriver:
		 * -open sourse tool
		 * -work on any browser(Chrome,firefox,IE,safari..)
		 * -support many program language(Java,Phyton,C#,JS)
		-program independent:windows,mac,linux
		*/
		/*
		 * HTML -hypertext markup lng
		 * HTML-head & bady
		 * only code inside bady-->can see on the page
		 * html is written using tags<>
		 * we have opening tags<script> and closing tags</script>
		 * <div id="page"> div is a tagName,id=attribute, "page"=attribute value
		 */
		/*Test case:
		 * open Chrome browser
		 * Navigate to "https://login.yahoo.com/config/login"
		 * verify title is
		 * enter email
		 * click next button
		 * enter pwd
		 * click sign in
		 * 
		 */
		// set up system property
		System.setProperty("webdriver.chrome.driver","C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
         //1- open chrome browser
		WebDriver driver=new ChromeDriver();
		//2-navigate to   "https://login.com/config/login"
		driver.get("https://login.yahoo.com/config/login");
		
		// 3-verify title is
		    String title =driver.getTitle();
		    System.out.println(title);//yahoo login
		// 4-  

	}
}
