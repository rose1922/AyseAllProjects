package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class Class01_TC2_HRMSApplicationNegativeLogin extends CommonMethods{

	/* TC 2: HRMS Application Negative Login:
	1. Open chrome browser
	2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	3. Enter valid username
	4. Leave password field empty
	5. Verify error message with text “Password cannot be empty” is displayed. */
	
	@BeforeClass	
	public void openChrome() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	@AfterClass
	
	public void closeChrome() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test (priority=1, enabled=true)
	public void InserCredentials() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2, dependsOnMethods = {"InserCredentials"} ,enabled=true)
	public void verifyEmptyPasswordMessage() {
		String expectedMessageText="Password cannot be empty";
		WebElement errorMessage=driver.findElement(By.id("spanMessage"));
		
		if(errorMessage.isDisplayed()) {
			System.out.println("Error message Displayed");
			
			if(expectedMessageText.equals(errorMessage.getText())) {
			System.out.println("Empty Password Message Text-PASS");
			}else {
			System.out.println("Empty Password Message Text-FAIL");
			}
		}else {
			System.out.println("Error message is NOT displayed");
		}
		
	}	
}
