package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTesting {
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
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//seleniumTesting//src//test//reports//cartReport//SportyShoeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("SportyShoe site automation", "test to validate cart workflow");
		
	}
	@Test
	public void testCart() throws Exception {
		try {
			driver.get("http://ec2-43-204-234-203.ap-south-1.compute.amazonaws.com:8080/SportyShoe/home");
			driver.findElement(pom.login_or_signUp_btn).click();
			driver.findElement(pom.fill_email).sendKeys("svkshrm@gmail.com");
			driver.findElement(pom.fill_passwd).sendKeys("Souvik99@");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/login.png");
			driver.findElement(pom.login_btn).click();
			test1.pass("Successfully logged in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			test1.fail("failed to logged in");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/failed_login.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.abc_product).click();
			test1.pass("Successfully added one item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/itemAdded.png");
		} catch (Exception e) {
			e.printStackTrace();
			test1.fail("failed to add one item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/addItemFailed.png");
		}
		try {
			driver.findElement(pom.home_btn).click();
			driver.findElement(pom.abc_product).click();
			test1.fail("failed to add item as it already added");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/duplicate.png");
			Thread.sleep(5000);
			boolean itemAlreadyAdded= driver.findElement(By.xpath("/html/body/text()[5]")).isDisplayed();
			Assert.assertEquals(itemAlreadyAdded, true,"This item is already in your cart");
		} catch (Exception e) {
			// TODO: handle exceptionst1.
			e.printStackTrace();
			test1.fail("failed because of and unexpected error");
		}
		try {
			driver.findElement(pom.remove_btn);
			test1.pass("successfully removed item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/removeitem.png");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.fail("failed to remove item");
			takeSnapShot.takeSnapShot1(driver, "/snapshot/cart/failedtoremove.png");
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
