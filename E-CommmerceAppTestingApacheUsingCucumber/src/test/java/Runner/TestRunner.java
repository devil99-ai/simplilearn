package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\svksh\\eclipse-workspace\\E-CommmerceAppTestingApacheUsingCucumber\\src\\test\\java\\resource\\AddToCart.feature",
glue= { "StepDefinations" },
monochrome= true,plugin= {"html:target/cucumber-reports/report.html"})
public class TestRunner {

}
