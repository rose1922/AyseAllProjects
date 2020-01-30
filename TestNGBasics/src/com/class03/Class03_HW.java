package com.class03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import com.utils.CommonMethods;

public class Class03_HW extends CommonMethods{

	/* TC 1: HRMS Add Employee: 
	Open chrome browser
	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	Login into the application
	Add 5 different Employees and create login credentials by providing: 
		First Name
		Last Name
		Username
		Password
	Provide Employee First and Last Name
	Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
	Close the browser
	Specify group for this test case, add it into specific suite and execute from xml file. */
	
	@BeforeClass
	public void openBrowser() {
		setUp("chrome", CommonMethods.HMRS_URL);
	}
	
	@BeforeMethod
	public void loginHRMS() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(dataProvider="getData")
	public void addEmp(String firstName, String lastName, String userName, String password, String screnshotName) throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		String empId=driver.findElement(By.id("employeeId")).getAttribute("value");
		
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		
		driver.findElement(By.id("btnSave")).click();
		
		String actualEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		Assert.assertEquals(actualEmpId, empId, "Employee ID did not match");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screen=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screen, new File("screenshots/HMRS/addEmpoyee/"+screnshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] data= {
				{"James", "Russel", "james@russel2", "Messel123.-=", "jamesRussel"},
				{"John", "Brown", "john@brown2", "Hnown123.-=","johnBrown"},
				{"Jackie", "Chan", "jackie@chan2", "Kiehan123.-=","jackieChan"},
				{"Lionel", "Messi", "lionel@messi2", "Nelsi123.-=", "lionelMessi"},
				{"Hakan", "Sukur", "hakan@sukur2", "Kankur123.-=", "hakanSukur"}
		};
		return data;
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
}
