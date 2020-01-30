package com.Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hepsi {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\roseo\\eclipse-workspace\\SeleniumBatchV\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();//control shift O yap
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login/n");
		
		// <input name="txtUsername" id="txtUsername" type="text">
		//driver.findElement(By.id("txtUsername")).sendKeys("sohilaryan"); //by dan sonra control shift O yap
				driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("sohilaryan");
//				driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("sohilaryan");
//				driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("sohilaryan");
//				String kullanici = userName.getAttribute("value");// bize sağladığımız özelliğin değerini verecektir.
//				System.out.println(kullanici);// sohilaryan degerini verir

				// <input name="txtPassword" id="txtPassword" type="password">
				driver.findElement(By.name("txtPassword")).sendKeys("Syntax@12");
//				driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Syntax@12");
//				driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("Syntax@12");
//				driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("Syntax@12");

				// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
				driver.findElement(By.className("button")).click();
//				driver.findElement(By.xpath ("//input[@name='Submit']")).click();
//				driver.findElement(By.xpath("//input[@type = 'submit']")).click();
//				driver.findElement(By.cssSelector("input[name='Submit']")).click();

				// id="welcome" class="panelTrigger activated-welcome">Welcome Sohil</a>
				driver.findElement(By.linkText("Welcome Sohil")).click();
				driver.findElement(By.partialLinkText("Welcome")).click(); // <a href="#"

				System.out.println(driver.getCurrentUrl());
				Thread.sleep(2000);

			//	<a href="#" id="welcome" class="panelTrigger">Welcome Sohil</a>
			//	driver.findElement(By.linkText("Welcome Sohil")).click();
			//driver.findElement(By.partialLinkText("Welcome")).click(); // <a href="#"

				//System.out.println(driver.getCurrentUrl());
			//	Thread.sleep(2000);

			
				// <a href="/humanresources/symfony/web/index.php/admin/changeUserPassword">Change Password</a>
				//driver.findElement(By.linkText("Change Password")).click();
			//	driver.findElement(By.partialLinkText("Change P")).click();
		
				driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
				driver.findElement(By.xpath("//a[contains(text(), 'Add Emp')]")).click();
				//driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("firstName")).sendKeys("sidika");
	}
		


}
