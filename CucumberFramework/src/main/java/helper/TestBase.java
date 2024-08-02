package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ConfigurationBrowser.BrowserType;
import configReader.ObjectRepo;
import configReader.PropertyFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {
	public static WebDriver driver;
	
	
	public WebDriver getBrowserObject(BrowserType bType) throws Exception{
	try{
		switch(bType) {
		case Chrome:
			driver = new ChromeDriver();
			return driver;
		case Firefox:
			driver = new FirefoxDriver();
			return driver;
		default:
			throw new Exception("Driver not Found");
		}
	}catch(Exception e) {
		throw e;
	}
	
	}
	public void setUpDriver(BrowserType bType) throws Exception {
		driver=getBrowserObject(bType);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
	}
	@Before
	public void before() throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		setUpDriver(ObjectRepo.reader.getBrowser());
	}
	@After
	public void ater() {
		driver.quit();
	}

}

