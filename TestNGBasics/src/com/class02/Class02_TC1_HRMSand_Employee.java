package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class Class02_TC1_HRMSand_Employee extends CommonMethods{

	@BeforeMethod	
	public void openChrome() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	@AfterMethod
	
	public void closeChrome() throws InterruptedException {
		driver.close();
	}

	@Test
	public void logoAndLogin() throws InterruptedException {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		boolean fullNameDisplayed=driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(fullNameDisplayed, "Full Name is not displayed");
		
		boolean empIdDisplayed=driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		softAssert.assertTrue(empIdDisplayed, "Employee ID is not displayed");
		
		boolean photoDisplayed=driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		softAssert.assertTrue(photoDisplayed, "Photograph is not displayed");
		
		String empName="Mehmet";
		String empLastName="Mehmetoglu";
		String empFullName=empName+" "+empLastName;
		
		driver.findElement(By.id("firstName")).sendKeys(empName);
		driver.findElement(By.id("lastName")).sendKeys(empLastName);
		
		String empID=driver.findElement(By.id("employeeId")).getText();
		
		driver.findElement(By.id("btnSave")).click();
		
		String actualEmpName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		softAssert.assertEquals(actualEmpName, empFullName, "Expected Employee name Mismatched");
		
		String actualEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		softAssert.assertEquals(actualEmpId, empID, "Ecpected Employee ID mismatched");
		
		
	}
}
