package com.practices;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods{

	@Test
	public void addEmployee() {
		LoginPageElements login= new LoginPageElements();		
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		DashboardPage dashboard=new DashboardPage();
		dashboard.navigateToAddEmployee();
		
		AddEmployeePageElements addEmp= new AddEmployeePageElements();
		sendText(addEmp.firstName, "Mario");
		sendText(addEmp.middleName,  "Mario");
		sendText(addEmp.lastName, "Jardel");
		
		String empId=addEmp.empId.getAttribute("value");
		
		click(addEmp.saveBtn);
		
		String actualEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		Assert.assertEquals(actualEmpId, empId);
		takeScreenShot("addEmp");
		
	}
}
