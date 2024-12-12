package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class AlertHandellingTest {
	
	@Test
	public void verifyAlerts() {
		FrameAndAlertHandelling fa = new FrameAndAlertHandelling();
		fa.openBrowser();
		fa.clickTryItButton();
		//fa.closeBrowser();
	}

}
