package HomePage;

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
import HomePage.PageObjectElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTesting {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//HomepageReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate Home Page validating");
		
	}
	@Test
	public void testHomePage() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\homePage\\login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\homePage\\failed_login.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			test1.pass("user navigated to home page");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\homePage\\homepage.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("user not in home page");
		}
		try {
			Assert.assertTrue(driver.findElement(pom.home_btn).isDisplayed());
			test1.pass("home button is displayed");
			Assert.assertTrue(driver.findElement(pom.edit_profile_btn).isDisplayed());
			test1.pass("edit button is displayed");
			Assert.assertTrue(driver.findElement(pom.logout_btn).isDisplayed());
			test1.pass("logout button is displayed");
			Assert.assertTrue(driver.findElement(pom.cart_btn).isDisplayed());
			test1.pass("cart button is displayed");
			Assert.assertTrue(driver.findElement(pom.your_orders_btn).isDisplayed());
			test1.pass("your order button is displayed");
			Assert.assertTrue(driver.findElement(pom.abc_product).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.acer_laptop).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.asus_motherboard).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.Hp_laptop).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.iphone).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.lenovo_laptop).isDisplayed());
			Assert.assertTrue(driver.findElement(pom.oneplus).isDisplayed());
			test1.pass("all Items are displayed");
			Assert.assertEquals(driver.getCurrentUrl(), "http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to validate home page");
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


