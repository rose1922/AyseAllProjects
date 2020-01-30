package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class Class02_TC1_HrmsAddEmployee extends CommonMethods{
	
	/* TC 1: HRMS Add Employee:
	1. Open chrome browser
	2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	3. Login into the application
	4. Click on Add Employee
	5. Verify labels: Full Name, Employee Id, Photograph are displayed
	6. Provide Employee First and Last Name
	7. Add a picture to the profile
	8. Verify Employee has been added successfully
	9. Close the browser */

	@BeforeTest
	public void openBrowser() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test
	public void validateAddEmpContent() throws InterruptedException {
		
		SoftAssert sAssert=new SoftAssert();
		
		Actions action=new Actions(driver);
		WebElement pimBtn=driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(pimBtn).perform();
		Thread.sleep(2000);		
		WebElement addEmpBtn=driver.findElement(By.id("menu_pim_addEmployee"));
		action.click(addEmpBtn).perform();
		
		//Verify labels: Full Name, Employee Id, Photograph are displayed
		
		boolean firstNameDisplayed=driver.findElement(By.xpath("//div[text()=' First Name']")).isDisplayed();
		sAssert.assertTrue(firstNameDisplayed);
		
		boolean middleNameDisplayed=driver.findElement(By.xpath("//div[text()='Middle Name']")).isDisplayed();
		sAssert.assertTrue(middleNameDisplayed);
		
		boolean lastNameDisplayed=driver.findElement(By.xpath("//div[text()=' Last Name']")).isDisplayed();
		sAssert.assertTrue(lastNameDisplayed);
		
		boolean empIdDisplayed=driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
		sAssert.assertTrue(empIdDisplayed);
		
		boolean photographDisplayed=driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
		sAssert.assertTrue(photographDisplayed);
		
		//Provide Employee First and Last Name
		
		WebElement firstName=driver.findElement(By.id("firstName"));
		action.click(firstName).sendKeys("Jamie").sendKeys(Keys.TAB).sendKeys("John").sendKeys(Keys.TAB).sendKeys("Redknap").perform();
		
		String expEmpId=driver.findElement(By.id("employeeId")).getAttribute("value");
		
		WebElement photo=driver.findElement(By.id("photofile"));
		action.sendKeys(photo, "C:\\Users\\asd\\Desktop\\Disney.jpg").perform();
		
		WebElement saveBtn=driver.findElement(By.id("btnSave"));
		action.click(saveBtn).perform();
		
		// verify employee is added successfully
		
		String actEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		sAssert.assertEquals(actEmpId, expEmpId, "Employee ID is mismatched");
		
		sAssert.assertAll();		
		
	}
	
	@AfterMethod
	public void logout() {
		Actions action=new Actions(driver);
		
		WebElement welcomeBtn=driver.findElement(By.id("welcome"));
		action.click(welcomeBtn).perform();
		
		WebElement logoutBtn=driver.findElement(By.xpath("//a[text()='Logout']"));
		action.click(logoutBtn).perform();
		
	}
	
	@AfterClass
	public void tearDownBrowser() {
		driver.quit();
	}
}
