package com.Test.Ankit.cucumber;




import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@CucumberOptions(features="src/test/resources/Feature/AutomationPracticeScenarios.feature",
glue="com.Test.Ankit.automation.steps",
plugin= {"html:target/cucumber-html-report","json:target/cucumber.json","usage:target/cucumberEx.json"}
		)

public class TestRunnerAutomation   {


}

  


