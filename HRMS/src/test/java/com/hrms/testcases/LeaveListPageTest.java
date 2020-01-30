package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPage;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LeaveListPageTest extends CommonMethods{

	@Test (groups="regression")
	public void leaveListHeading() throws InterruptedException {
		
		LoginPageElements login=new LoginPageElements();			
		login.login();	
				
		DashboardPage dp=new DashboardPage();
		dp.navigateToLeaveList();

		LeaveListPageElements llp=new LeaveListPageElements();	
		
		waitForVisibility(llp.leaveListHeader);
		Assert.assertTrue(llp.leaveListHeader.isDisplayed(), "Label is not displayed");	
	}
}
