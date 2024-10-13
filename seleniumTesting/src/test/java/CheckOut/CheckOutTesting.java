package CheckOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CheckOut.PageObjectElement;
import Cart.takeSnapShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckOutTesting {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//CheckoutReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate checkout workflow");
		
	}
	@Test
	public void testCheckOut() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/failed_login.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.abc_product).click();
			test1.pass("Successfully added one item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/itemAdded.png");
		} catch (Exception e) {
			e.printStackTrace();
			test1.fail("failed to add one item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/addItemFailed.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.iphone).click();
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.Hp_laptop).click();
			test1.pass("Successfully added 3 items in cart");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/items.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to add items in cart");
		}
		try {
			driver.findElement(pom.checkout_btn).click();
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Sporty Shoes - Checkout");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/checkout/checkoutpage.png");
			test1.pass("user successfully navigated to checkout page");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to navigate to checkout page");
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