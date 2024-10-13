package Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Cart.takeSnapShot;
import Dashboard.PageObjectElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardTest {
	WebDriver driver;
	PageObjectElement pom;
	takeSnapShot takeSnapshot;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	@BeforeTest
	public void OpenBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		pom = new PageObjectElement();
		takeSnapshot = new takeSnapShot();
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//dashboardReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate dashboard workflow");
		
	}
	@Test
	public void testDashboard() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\dashboard\\login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\dashboard\\failed_login.png");
		}
		try {
			String actualTitle = driver.getTitle();
			String expectedTitle = "Sporty Shoes - Dashboard";
			Assert.assertEquals(actualTitle, expectedTitle);
			test1.pass("User successfully navigated to dashboard");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\dashboard\\dashboard.png");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("user failed to navigated to dashboard");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\dashboard\\failedToNavigateToDashboard.png");
		}

	}
	@AfterTest
	public void closeBrowser() {
		try{
			driver.close();
			test1.info("after successful test execution browser closed");
			extent.flush();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to close browser test is unsuccessfull");
		}
		
	}
}
