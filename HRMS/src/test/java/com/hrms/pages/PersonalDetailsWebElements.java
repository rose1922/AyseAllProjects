package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsWebElements  extends BaseClass{

	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	public PersonalDetailsWebElements() {
		PageFactory.initElements(driver, this);
	}
}
