package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class TitleLogoAndLoginVerification extends CommonMethods{

	@BeforeMethod (alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	
	@AfterMethod (alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups="regression")
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test (groups="regression")
	public void validateLogo() {
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogin']/div/img"));
		boolean isDisplayed=logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(groups="regression")
	public void validateLogin() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertTrue(false);
	}
}