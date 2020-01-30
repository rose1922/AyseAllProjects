package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class Class01_TC1_HRMSApplicationLogin extends CommonMethods{
	
	/* TC 1: HRMS Application Login:
	1. Open chrome browser
	2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/ auth/login”
	3. Enter valid username and password
	4. Click on login button
	5. Then verify Syntax Logo is displayed
	6. Close the browser */

	@BeforeMethod	
	public void openChrome() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	@AfterMethod
	
	public void closeChrome() throws InterruptedException {
		driver.close();
	}
	
	@Test
	public void validateLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		String expectedText="Welcome Admin";
		String welcomeText=driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(welcomeText, expectedText, "Login with valid credentials is SUCCESSFUL");
	}
	
	@Test
	public void syntaxDemo() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		WebElement logo=driver.findElement(By.xpath("//div[@id='wrapper']/div/a"));
		boolean isDisplayed=logo.isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax Logo is DISPLAYED");
	}
	
	
}
