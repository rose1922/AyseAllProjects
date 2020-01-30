package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.AddCandidatePageWebElements;
import com.hrms.pages.CandidatesPageWebElements;
import com.hrms.pages.DashboardPageWebElements;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CandidatesSteps extends CommonMethods{
	
	public CandidatesPageWebElements candidate;
	public AddCandidatePageWebElements addCand;

	@Given("i navigate to Candidates Page")
	public void i_navigate_to_Candidates_Page() {
		DashboardPageWebElements dashboard=new DashboardPageWebElements();
		dashboard.navigateToCandidatesPage();
	}

	@When("i enter {string}")
	public void i_enter(String string) {
		candidate=new CandidatesPageWebElements();
		sendText(candidate.candidateName, string);
	}

	@When("i click search button in Candidate")
	public void i_click_search_button_in_Candidate() {
		candidate=new CandidatesPageWebElements();
		click(candidate.searchBtn);
	}

	@Then("i see candidate name in search results")
	public void i_see_candidate_name_in_search_results() {
		candidate=new CandidatesPageWebElements();
		boolean candidateNameDis=candidate.candidateNameInResultTable.isDisplayed();
		Assert.assertTrue("Candidate Name did not displayed", candidateNameDis);
		
	}

	@When("i click Add button")
	public void i_click_Add_button() {
		candidate=new CandidatesPageWebElements();
		click(candidate.addBtn);
	}

	@When("i enter {string}, {string}, {string} and {string}")
	public void i_enter_and(String string, String string2, String string3, String string4) {
		addCand=new AddCandidatePageWebElements();
		
	}

	@When("i select Job Vacancy")
	public void i_select_Job_Vacancy() {

	}

	@When("i select {string}, {string} and {string} of Application")
	public void i_select_and_of_Application(String string, String string2, String string3) {

	}

	@Then("i see Candidate is added successfully")
	public void i_see_Candidate_is_added_successfully() {

	}
}
