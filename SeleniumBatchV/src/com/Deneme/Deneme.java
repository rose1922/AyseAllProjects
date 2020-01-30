package com.Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	
	WebDriver dr=new ChromeDriver();//chromu dr degerine ata
	
	dr.get("https://www.facebook.com//");//gidecegin sayfayi yaz
	
	System.out.println(dr.getTitle()); //sayfanin icerigi
	dr.findElement(By.id("email")).sendKeys("sdk.babadag@gmail.com");
	dr.findElement(By.id("pass")).sendKeys("Laura1286");
	dr.findElement(By.xpath("//input[@type='submit']")).click();

	
	
	
}
	
}
