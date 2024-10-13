package OrderHistory;

import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;
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
import OrderHistory.PageObjectElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderHistoryTest {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//OrderHistoryReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate Order history workflow");
		
	}
	@Test
	public void testOrderHistory() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\failed_login.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			test1.pass("user navigated to home page");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\homepage.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("user not in home page");
		}
		try {
			driver.findElement(pom.abc_product).click();
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.iphone).click();
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.Hp_laptop).click();
			test1.pass("user added 3 items in cart successfully");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\cart.png");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to added items in cart");
		}
		try {
			driver.findElement(pom.checkout_btn).click();
			test1.pass("user successfully check out and navigated to payment page");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\payment.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to get payment page");
		}
		try {
			driver.findElement(pom.pay_btn).click();
			test1.pass("user successfully paid for items");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\paymentGateway.png");
			driver.findElement(pom.complete_purchase_btn);
			test1.pass("successfully placed order");
			takeSnapShot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\seleniumTesting\\snapshot\\orderHistory\\orderplaced.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to place order");
		}
		try {
			driver.findElement(pom.order_history_btn).click();
			String expectedtitle = driver.getTitle();
			String actualitle = "Sporty Shoes - Purchase Confirmation";
			Assert.assertEquals(expectedtitle, actualitle);
			takeSnapShot.takeSnapShot1(driver, "C:\\\\Users\\\\svksh\\\\eclipse-workspace\\\\seleniumTesting\\\\snapshot\\\\orderHistory\\\\orderhisotry.png");
			test1.pass("user successfully navigated to order history page");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("user failed to check order history");
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

