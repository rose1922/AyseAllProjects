package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageWebElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps extends CommonMethods{

	LoginPageWebElements login;

	@Given("i enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		login=new LoginPageWebElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password,  ConfigsReader.getProperty("password"));		
	}

	@When("i click login button")
	public void _click_login_button() {
		click(login.loginBtn);
	}

	@Then("i successfully logged in")
	public void i_successfully_logged_in() {
		System.out.println("I am logged in");
	}

	@Then("i see welcome text")
	public void i_see_welcome_text() {
		System.out.println("I see welcome text");
	}
	
	@Given("i enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		login=new LoginPageWebElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password,  "qwerty123");
	}

	@Then("i see -Invalid credentials-message")
	public void i_see_Invalid_credentials_message() {
		boolean error=login.errorMessage.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}
}
