package com.class02;


	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class Task {
		
		public static void main(String[] args) throws InterruptedException {
			System.setProperty(“webdriver.chrome.driver”,
					“/Users/sidikababadag/eclipse-workspace/SeleniumBatchV/drivers/chromedriver”);
			WebDriver driver = new ChromeDriver();
			driver.get(“http://newtours.demoaut.com/”);
			// driver.findElement(By.linkText(“SIGN-ON”)).click();
			driver.findElement(By.linkText(“REGISTER”)).click(); // <a href=“mercuryregister.php”>REGISTER</a>
			driver.findElement(By.name(“firstName”)).sendKeys(“Ali”); // <input maxlength=“60” name=“firstName” size=“20”>
			driver.findElement(By.name(“lastName”)).sendKeys(“Kos”); // <input maxlength=“60" name=“lastName” size=“20">
			driver.findElement(By.name(“phone”)).sendKeys(“5248 5887"); // <input maxlength=“20” name=“phone” size=“15”>
			driver.findElement(By.name(“address1")).sendKeys(“0123 Spring”); // <input maxlength=“60" name=“address1”
																				// size=“40">
			driver.findElement(By.name(“address2”)).sendKeys(“02587 cross”);// <input maxlength=“60” name=“address2"
																			// size=“40”>
			driver.findElement(By.name(“city”)).sendKeys(“Houston”);// <input maxlength=“60" name=“city” size=“15">
			driver.findElement(By.name(“state”)).sendKeys(“TX”); // <input maxlength=“40” name=“state”>
			driver.findElement(By.name(“postalCode”)).sendKeys(“77479");// <input maxlength=“20” name=“postalCode”
																		// size=“15”>
			driver.findElement(By.name(“country”)).sendKeys(“United States”);//// <select name=“country”
																				//// size=“1”>...</select>
			driver.findElement(By.id(“email”)).sendKeys(“sdk@gmail.com”);// <input name=“email” id=“email” size=“20"
																			// maxlength=“60”>
			driver.findElement(By.name(“password”)).sendKeys(“sdkbbd123.“);// <input maxlength=“60” name=“password”
																			// size=“20” type=“password”>
			driver.findElement(By.name(“confirmPassword”)).sendKeys(“sdkbbd123.“);// <input maxlength=“60”
																					// name=“confirmPassword” size=“20”
																					// type=“password”>
			driver.findElement(By.name(“register”)).click();// <input type=“image” name=“register”
															// src=“/images/forms/submit.gif” width=“60” height=“23"
															// border=“0”>
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			System.out.println(“thank you for registration”);
			// driver.close();
			driver.findElement(By.linkText(“sign-in”)).click();// <a href=“mercurysignon.php”> sign-in </a>
			driver.findElement(By.name(“userName”)).sendKeys(“sdk@gmail.com”);// <input maxlength=“60” name=“userName”
																				// size=“20”>
			driver.findElement(By.name(“password”)).sendKeys(“sdkbbd123.“);// <input maxlength=“60” name=“password”
																			// size=“20” type=“password”>
			driver.findElement(By.name(“login”)).click();// <input type=“image” name=“login” value=“Login” alt=“Login”
															// border=“0" src=“/images/forms/submit.gif” width=“60"
															// height=“23”>
		}
	}


