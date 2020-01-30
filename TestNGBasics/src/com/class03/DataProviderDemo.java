package com.class03;
/*
 * Verify user is able to login into hrms with different uid and pwd
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods{

	@BeforeMethod
	public void openBrowser() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String password) throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtUsername")));
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.name("Submit")).click();
		
		String expectedWelcomeText="Welcome"+" "+username;
		String actualWelcomeText=driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "Welcome Text Did Not Match");
	}
	
	//to create a data provider we need to create a method that will be returning 
	// Object 2D array
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data= {
				{"Admin", "Hum@nhrm123"},
				{"Syntax", "Syntax123!"},
				{"SyntaxUser", "Syntax123!"}
		};
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}