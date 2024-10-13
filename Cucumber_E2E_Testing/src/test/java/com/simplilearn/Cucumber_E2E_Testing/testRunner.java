package com.simplilearn.Cucumber_E2E_Testing;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\svksh\\eclipse-workspace\\Cucumber_E2E_Testing\\src\\test\\java\\resource\\Cucumber_end2end_Test.feature"}, monochrome=true, plugin = {
        "html:target/cucumber-reports/report.html" }
		 )
public class testRunner {

}
