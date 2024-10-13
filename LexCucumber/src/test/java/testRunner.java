

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\java\\resource\\first.feature"},
		glue={"src\\test\\java\\com\\simplilearn\\LexCucumber\\"},
		plugin={"html:src\\reports\\rep.html","junit:src\\reports\\rep1.xml","json:\\src\\reports\\rep2.json"}
		
		)
public class testRunner {

}
