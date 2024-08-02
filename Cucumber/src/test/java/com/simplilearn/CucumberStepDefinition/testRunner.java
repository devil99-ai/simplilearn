package com.simplilearn.CucumberStepDefinition;

import org.junit.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

//import io.cucumber.core.options.Constants;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("eclipse-workspace")
@SelectClasspathResource("resource")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class testRunner {
	@Test
	public void testDemo() {
		System.out.println("This is a test");
	}

}