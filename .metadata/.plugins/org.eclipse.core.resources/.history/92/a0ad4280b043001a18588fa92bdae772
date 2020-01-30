package com.hrms.steps;


import com.hrms.utils.CommonMethods;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks extends CommonMethods{

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting scenario "+scenario.getName());
		setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Starting scenario "+scenario.getName());
		tearDown();
	}
}
