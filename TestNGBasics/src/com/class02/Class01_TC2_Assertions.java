package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class Class01_TC2_Assertions extends CommonMethods{

	/* TC 2: HRMS Application Negative Login:
	1. Open chrome browser
	2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	3. Enter valid username
	4. Leave password field empty
	5. Verify error message with text “Password cannot be empty” is displayed. */
	
	@BeforeMethod	
	public void openChrome() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	@AfterMethod
	
	public void closeChrome() throws InterruptedException {
		driver.close();
	}
	
	@Test
	public void verifyEmptyPasswordMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		String expectedMessageText="Password cannot be empty";
		WebElement actualErrorMessage=driver.findElement(By.id("spanMessage"));
		Assert.assertTrue(actualErrorMessage.isDisplayed(), "Error message is NOT displayed");
		Assert.assertEquals(actualErrorMessage.getText(), expectedMessageText, "Displaying Wrong Error Message");
	}	
}
