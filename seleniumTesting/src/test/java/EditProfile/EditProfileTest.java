package EditProfile;

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
import EditProfile.PageObjectElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfileTest {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//editProfileReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate edit profile workflow");
		
	}
	@Test
	public void testEditProfile() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\editProfile\\login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\editProfile\\failed_login.png");
		}
		try {
			driver.findElement(pom.edit_profile_btn).click();
			test1.pass("user navigated to edit profile page");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\editProfile\\editProfile_page.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\editProfile\\FailedEditProfile_page.png");
			test1.fail("user failed to navigated to edit profile");
			
		}
		try {
			driver.findElement(pom.password).sendKeys("Souvik99@");
			driver.findElement(pom.confirm_password).sendKeys("Souvik99@");
			driver.findElement(pom.address_fill).clear();
			driver.findElement(pom.address_fill).sendKeys("A.C.Road(North)");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\editProfile\\NewDetailsInProfile_page.png");
			driver.findElement(pom.update_btn).click();
			test1.pass("user successfully edited profile");
			Assert.assertEquals(driver.getCurrentUrl(), "http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/dashboard");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("user failed to update profile");
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

