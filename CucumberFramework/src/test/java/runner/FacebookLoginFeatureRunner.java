package runner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstructTestNGCucumberTests;

@CucumberOptions(features= {"classpath:feature/Login.feature"},glue= {"classpath:stepdefinition","classpath:helper"},plugin= {"html:target/cucumber-html-resource"})
public class FacebookLoginFeatureRunner extends AbstructTestNGCucumberTests{

}
