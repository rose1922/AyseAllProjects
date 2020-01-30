package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

/*  Open application
 * Verify logo is displayed
 * enter valid credentials
 * verify user successfully is logged in
 */
public class SoftAssertionDemo extends CommonMethods{

	@BeforeMethod	
	public void openChrome() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	@AfterMethod
	
	public void closeChrome() throws InterruptedException {
		driver.close();
	}

	@Test
	public void logoAndLogin() {
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
//		logoDisplayed=false;
//		Assert.assertTrue(logoDisplayed, "Logo is not Displayed");
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		String welcomeText=driver.findElement(By.id("welcome")).getText();
		String expectedText="Welcome Admin";
		
		softAssert.assertEquals(welcomeText, expectedText, "Welcome element is not displayed");
		
		softAssert.assertAll();

	}
}
