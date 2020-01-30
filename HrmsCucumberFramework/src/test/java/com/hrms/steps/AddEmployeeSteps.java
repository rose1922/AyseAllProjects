package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageWebElements;
import com.hrms.pages.DashboardPageWebElements;
import com.hrms.pages.LoginPageWebElements;
import com.hrms.pages.PersonalDetailsWebElements;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods{
	
	AddEmployeePageWebElements addEmp;
	
	@Given("i am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		LoginPageWebElements login=new LoginPageWebElements();
		login.login();
	}

	@Given("i navigated to Add Employee Page")
	public void i_click_PIM_and_Add_Employee_button() {
		DashboardPageWebElements dashboard=new DashboardPageWebElements();
		dashboard.navigateToAddEmployee();
	}

	@When("i add firstName, middleName and last name")
	
	public void i_add_firstName_middleName_and_last_name() {
		addEmp=new AddEmployeePageWebElements();
		sendText(addEmp.firstName, "Kobe");
		sendText(addEmp.middleName,  "Kobe");
		sendText(addEmp.lastName,  "Bryant");
	}

	@When("i click Create Login Details")
	public void i_click_Create_Login_Details() {
		click(addEmp.createLoginDetails);
	}

	@When("i enter username-password-confirm password")
	public void i_enter_username_password_confirm_password() {
		sendText(addEmp.username,  "kobe@bryant");
		sendText(addEmp.userPassword,  "Kobe@bryant123-=.");
		sendText(addEmp.confirmUserPassword, "Kobe@bryant123-=.");
		
		System.out.println("getAttribute-->"+addEmp.empId.getAttribute("value"));
		
		System.out.println("getText-->"+addEmp.empId.getText());
		
	}

	@When("i click Save button")
	public void i_click_Save_button() {
		addEmp=new AddEmployeePageWebElements();
		click(addEmp.saveBtn);
	}

	@Then("i will see Personal Details")
	public void i_will_see_Personal_Details() {
		PersonalDetailsWebElements pd= new PersonalDetailsWebElements();
		boolean empPictureDisp=pd.empPicture.isDisplayed();
		Assert.assertTrue("Employee Picture is not displayed,",  empPictureDisp);
	}

	@When("i add {string}, {string} and {string}")
	public void i_add_and(String string, String string2, String string3) {
		addEmp=new AddEmployeePageWebElements();
		sendText(addEmp.firstName, string);
		sendText(addEmp.middleName, string2);
		sendText(addEmp.lastName, string3);
	}

	@Then("i see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String string, String string2, String string3) {
		PersonalDetailsWebElements pd= new PersonalDetailsWebElements();
		String actFirstName=pd.firstName.getAttribute("value");
		String actMiddleName=pd.middleName.getAttribute("value");
		String actLastName=pd.lastName.getAttribute("value");
				
		Assert.assertTrue("First name MISMATCH", string.equals(actFirstName));		
		Assert.assertTrue("Middle name MISMATCH", string2.equals(actMiddleName));		
		Assert.assertTrue("Last name MISMATCH", string3.equals(actLastName));
		
		
		
//		String expName=string+" "+string2+" "+string3;
//		String actName=pd.nameOnPicture.getText();
//		
//		System.out.println(expName);
//		System.out.println(actName);
//		
//		Assert.assertTrue("Employee name mismatch", (expName.contains(string)&&expName.contains(string2)&&expName.contains(string3)));		
	}

	@When("i delete employee id")
	public void i_delete_employee_id() {
		addEmp=new AddEmployeePageWebElements();
		addEmp.empId.clear();
	}

	@Then("i see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
		PersonalDetailsWebElements pd=new PersonalDetailsWebElements();
		boolean empIdIsEmpty=pd.empId.getAttribute("value").isEmpty();
		Assert.assertTrue("Employee ID is not Empty", empIdIsEmpty);
	}

	@Then("i see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		addEmp=new AddEmployeePageWebElements();
		String firstNameErrDisp=addEmp.firstNameError.getText();
		String lastNameErrDisp=addEmp.lastNameError.getText();
		
		boolean errDisplayed=false;
		if(!firstNameErrDisp.isEmpty()) {
			errDisplayed=true;
		}
		
		Assert.assertTrue("First name Required message is not Displayed", errDisplayed);
		
		errDisplayed=false;
		
		if(!lastNameErrDisp.isEmpty()) {
			errDisplayed=true;
		}
		
		Assert.assertTrue("Last name Required message is not Displayed", errDisplayed);
	}
	
	

	

}
