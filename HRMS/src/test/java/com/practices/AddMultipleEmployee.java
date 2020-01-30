package com.practices;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsWebElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddMultipleEmployee extends CommonMethods{

	@Test(dataProvider="getData")
	public void addMultipleEmpoyee(String firstName, String middleName, String lastName, String username, String password) throws InterruptedException {
		LoginPageElements login=new LoginPageElements();
		login.login();
		DashboardPage dasboard=new DashboardPage();
		dasboard.navigateToAddEmployee();
		
		AddEmployeePageElements addEmp=new AddEmployeePageElements();
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
		
		click(addEmp.createLoginDetails);
		
		sendText(addEmp.username, username);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.confirmUserPassword, password);
		
		String empId=addEmp.empId.getAttribute("value");
		
		Thread.sleep(1000);
		click(addEmp.saveBtn);		
		
		PersonalDetailsWebElements pdw= new PersonalDetailsWebElements();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(pdw.empId));		
		String actEmpId=pdw.empId.getAttribute("value");
	
		Assert.assertEquals(actEmpId, empId);
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmp");
	}
}
