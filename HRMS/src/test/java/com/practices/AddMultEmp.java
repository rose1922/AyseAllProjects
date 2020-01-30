package com.practices;

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

public class AddMultEmp extends CommonMethods{

	@Test(dataProvider="getData")
	public void addEmployee(String firstName, String middleName, String lastName,
			String username, String password) {
		LoginPageElements login=new LoginPageElements();
		login.login();
		DashboardPage dashboard=new DashboardPage();
		dashboard.navigateToAddEmployee();
		
		AddEmployeePageElements addEmp= new AddEmployeePageElements();
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName,  middleName);
		sendText(addEmp.lastName,  lastName);
		
		click(addEmp.createLoginDetails);
		
		sendText(addEmp.username, username);
		sendText(addEmp.userPassword,  password);
		sendText(addEmp.confirmUserPassword,  password);
		
		click(addEmp.saveBtn);
		PersonalDetailsWebElements pd=new PersonalDetailsWebElements();

		boolean empPicDisp=pd.empPicture.isDisplayed();
		Assert.assertTrue(empPicDisp, "Employee picture is NOT displayed");
		
		takeScreenShot("addEmployee");
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmp");
	}
}
