package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\svksh\\eclipse-workspace\\E-CommmerceAppTestingApacheUsingCucumber\\src\\test\\java\\resource\\AddToCart.feature",
glue= { "StepDefinations" },
monochrome= true,plugin= {"pretty","html:target/apache-html-report"})
public class TestRunner {

}
