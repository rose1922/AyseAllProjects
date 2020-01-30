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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class Zoom_Class03_HW extends CommonMethods{
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
	
	/* @BeforeClass
	 * 1. Open Browser
	 * 2. Navigate to HRMS page
	 * 
	 * @BeforeMethod
	 * 3. Login HRMS
	 * 
	 * @Test
	 * 4. Click PMI Btn
	 * 5. Click Add Employee Btn
	 * 6. Enter Employee Information /firstName, lastName, userName, Password, confirmPassword
	 * 7. Verify employee is added successfully
	 * 8. Take Screen Shot
	 * 
	 * @AfterMethod
	 * 9. LogOut
	 * 
	 * @AfterClass
	 * 10. Quit Browser
	 */
	
	@BeforeClass (alwaysRun=true)
	public void openBrowser() {
		setUp("chrome", CommonMethods.HMRS_URL);
		
	}
	
	@BeforeMethod (alwaysRun=true)
	public void login(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(dataProvider="getData" ,groups="regression")
	public void addEmployee(String firstName, String lastName, String userName, String password,
			String fileName) {
		// navigate to add employee menu
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
//		WebDriverWait wait1=new WebDriverWait(driver, 20);
//		wait1.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		// adding employee information
		
//		WebDriverWait wait2=new WebDriverWait(driver, 20);
//		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("firstName")));
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		// click 
		driver.findElement(By.id("chkLogin")).click();
		
		// enter username, password and confirm password
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		
		// click save button
		driver.findElement(By.id("btnSave")).click();
		
		// verify employee is added successfully
		
		String expectedName=firstName+" "+lastName;
		String actualName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		Assert.assertEquals(actualName, expectedName, "Ecpected and Actual names Mismatched");
		
		// take screen shots
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/HRMS/addEmployee/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= {
				{"john", "walker", "john@walker12", "Hnker123.-=", "johnWalker"},
				{"jackie", "james", "jackie@james12", "Kiemes123.-=", "jackieJames"},
				{"jenny", "cancan", "jenny@cancan12", "Nycan123.-=", "jennyCancan"},
				{"jeremy", "cikcik", "jeremy@cikcik12", "Emycik123.-=", "jeremyCikcik"},
				{"vlad", "sleeper", "vlad@sleeper12", "Ladper123.-=", "vladSleeper"}
		};
		return data;
	}
	
	@AfterMethod (alwaysRun=true)
	public void logout(){
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass (alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	

	
}
