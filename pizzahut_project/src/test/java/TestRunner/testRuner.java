package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\svksh\\eclipse-workspace\\pizzahut_project\\src\\test\\resource\\automationSteps.feature"},glue = "stepDefinations" , monochrome=true, plugin = {
        "html:target/cucumber-reports/report.html"})
public class testRuner {

}
