package com.simplilearn.CucumberStepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\svksh\\eclipse-workspace\\Cucumber\\src\\test\\java\\resource\\selenium.feature", glue= {"com.simplilearn.CucumberStepDefinition"},
monochrome= true,plugin={"pretty","html:target/htmlReport",
		"junit:target/JunitReports/report.xml",
		"json:target/JSONReports/report.json"})

public class googleTestRunner {
	

}
