package com.hrms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods{
	
		@Test (groups= {"regression", "smoke"})
		
		
		public void loginWithValidCredentials() {
			
			test.info("Logging in the application");
			
			LoginPageElements login=new LoginPageElements();			
			sendText(login.username, ConfigsReader.getProperty("username"));
			sendText(login.password,  ConfigsReader.getProperty("password"));
			click(login.loginBtn);
			
			test.info("Verifying the login with valid credentials");
			
			boolean containsUsername=driver.findElement(By.id("welcome")).getText().contains("Admin");
			Assert.assertTrue(containsUsername, "Welcome text does not contains Username");
		}
		
		@Test(groups="regression")
		public void loginWithEmptyPassword() {
			
			LoginPageElements login=new LoginPageElements();			
			sendText(login.username, ConfigsReader.getProperty("username"));
			click(login.loginBtn);
			
			String expErrMsg="Password cannot be empty";
			Assert.assertEquals(login.errorMessage.getText(), expErrMsg, "Error message mismatch");			
		}
		
		@Test(groups="regression")
		public void loginWithEmptyUsername() {
			
			LoginPageElements login=new LoginPageElements();			
			click(login.loginBtn);
			
			final String expErrMsg="Username cannot be empty";
			Assert.assertEquals(login.errorMessage.getText(), expErrMsg, "Error message mismatch");			
		}
		
		@Test(groups="regression")
		
		public void loginWithInvalidCredentilas() {
			
			LoginPageElements login=new LoginPageElements();			
			sendText(login.username, "Qwert");
			sendText(login.password,  "Muh@nfsf123");
			click(login.loginBtn);
			
			final String expErrMsg="Invalid credentials";
			Assert.assertEquals(login.errorMessage.getText(), expErrMsg, "Error message mismatch");

		}
		
		@Test(groups="regression")
		public void sysntaxLogoDisplayed() {
			
			LoginPageElements login=new LoginPageElements();
			boolean syntaxLogoIsDisplayed=login.syntaxLogo.isDisplayed();
			
			Assert.assertTrue(syntaxLogoIsDisplayed, "Syntax Logo is not Displayed");
		}
		
		@Test(groups="regression")
		public void loginPanelHeading() {
			
			LoginPageElements login=new LoginPageElements();
			String loginPanelHeaderText=login.loginPanelHeading.getText();
			
			final String expPanelHeadingText="LOGIN Panel";
			Assert.assertEquals(loginPanelHeaderText, expPanelHeadingText, "Login Panel Header Mismatch");
		}
		
		@Test(groups="regression")
		public void titleValidation() {			
			final String expTitle="Syntax HRM";			
			String actTitle=driver.getTitle();
			Assert.assertEquals(actTitle, expTitle, "Title mismatch");
		}
		
		@Test(dataProvider="getData", groups= {"regression", "smoke"})
		public void multipleLogin(String uid, String pwd) throws InterruptedException {
			LoginPageElements login = new LoginPageElements();
			login.login(uid,  pwd);
			Thread.sleep(3000);
		}
	
		@DataProvider
		public Object[][] getData(){
			return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Login");
		}
		
}
