package SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Cart.takeSnapShot;
import SignUp.PageObjectElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testSignUp {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//SignUpReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate SignUp workflow");
		
	}
	@Test
	public void testSignUpPage() {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\signUp\\loginpage.png");
			test1.pass("user is in login page");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to navigate to login page");
		}
		try {
			driver.findElement(pom.sign_up_btn).click();
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\signUp\\signUpPage.png");
			test1.pass("user is in login page");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to navigate to signUp page");
		}
		try {
			driver.findElement(pom.fill_email).sendKeys("johnsnow@email.com");
			driver.findElement(pom.fill_first_name).sendKeys("john");
			driver.findElement(pom.fill_last_name).sendKeys("snow");
			driver.findElement(pom.fill_age).sendKeys("30");
			driver.findElement(pom.fill_password).sendKeys("john123");
			driver.findElement(pom.fill_confirm_password).sendKeys("john123");
			driver.findElement(pom.fill_address).sendKeys("Baking Hum palace, London");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\signUp\\filledDetails.png");
			test1.pass("user successfully filled details");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to fill details");
		}
		try {
			driver.findElement(pom.click_sign_up);
			test1.pass("successfully registered as a user");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\signUp\\signedUp.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to sign up as a user");
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