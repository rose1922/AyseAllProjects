package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementDemo {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
    driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
    
    
    driver.findElement(By.id("txtUsername")).sendKeys("admin");
    driver.findElement(By.id("txtPasword")).sendKeys("@gmail.com");	
    driver.findElement(By.id("btnLogin")).click();	
}
}
