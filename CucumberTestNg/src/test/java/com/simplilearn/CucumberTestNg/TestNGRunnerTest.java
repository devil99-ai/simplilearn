package com.simplilearn.CucumberTestNg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(cucumber.api.junit.Cucumber.class)
@CucumberOptions(features={"src\\test\\java\\resource"},plugin = {
"html:target/cucumber-reports/report.html" }, monochrome = true)
public class TestNGRunnerTest{

}
