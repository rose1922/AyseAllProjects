package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features"
		,glue="com/hrms/steps"
		,dryRun=true
		,plugin="pretty"
		,monochrome=true
		,tags= {"@hasan"}
		)


public class RunnerClass {
}
