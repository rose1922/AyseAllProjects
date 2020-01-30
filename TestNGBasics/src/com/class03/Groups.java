package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class Groups extends CommonMethods{
	
	@BeforeMethod (alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}


	@Test (priority=2, groups={"regression", "login"})
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test-PASS");
		}else {
			System.out.println("Test-FAIL");
		}
	}
	
	@Test (priority=2, groups= {"regression", "login"})
	public void validateLogo() {
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogin']/div/img"));
		boolean isDisplayed=logo.isDisplayed();
		if(isDisplayed) {
			System.out.println("Logo test-PASS");
		}else {
			System.out.println("Logo test-FAIL");
		}
	}
	
	@Test (priority=1, groups= {"smoke", "login"})
	public void validateLogin() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		String welcomeText=driver.findElement(By.id("welcome")).getText();
		if(welcomeText.contains("Admin")) {
			System.out.println("Login test-PASS");
		}else {
			System.out.println("Login test-FAIL");
		}
	}
}
