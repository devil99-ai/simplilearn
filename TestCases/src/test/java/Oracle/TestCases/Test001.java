package Oracle.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test001 {
	WebDriverWait wait;
	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		htmlReporter=new ExtentSparkReporter("C:\\Users\\svksh\\eclipse-workspace\\TestCases\\reports\\extentReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("Oracle Testing", "test to validate workflow ");
		
	}
	@AfterTest
	public void tearDown() {
		//driver.close();
		extent.flush();
	}
	@Test
	public void testHTR_001() throws InterruptedException, IOException {
		driver.get("https://fa-erzp-dev27-saasfademo1.ds-fa.oraclepdemos.com/fscmUI/faces/FuseMobileWelcome?_afrLoop=21878966728991130&_adf.ctrl-state=1ce355cno5_62");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys("philip.kent");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("uM?4F8*z");
			driver.findElement(By.xpath("//*[@id=\"btnActive\"]")).click();
			Thread.sleep(5000);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("src/test/java/homepage.png"));
			//if(driver.getCurrentUrl().equals("https://fa-erzp-dev27-saasfademo1.ds-fa.oraclepdemos.com/fscmUI/faces/FuseMobileWelcome?_adf.ctrl-state=rty538sju_1&_adf.no-new-window-redirect=true&_afrLoop=21905651737758428&_afrWindowMode=2&_afrWindowId=null&_afrFS=16&_afrMT=screen&_afrMFW=1699&_afrMFH=941&_afrMFDW=1707&_afrMFDH=1067&_afrMFC=8&_afrMFCI=0&_afrMFM=0&_afrMFR=144&_afrMFG=0&_afrMFS=0&_afrMFO=0")) {
			if(driver.getTitle().equals("Oracle Fusion Cloud Applications")){		
				test1.pass("Successfully logged in into Oracle RMC");
			}else {
				test1.fail("failed to logged in into oracle RMC");
			}
		}catch (Exception e) {
			e.printStackTrace();
			test1.fail("failed to logged in into oracle RMC"+e.getLocalizedMessage());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("src/test/java/homepageError.png"));
		}
		try {
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"FMOpt1:_UISdr1::icon\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"FMOpt1:_UISr1:0:nvgpgl2_groupNode_risk_management\"]/div[1]")).click();
			WebElement element = driver.findElement(By.xpath("//*[@id=\"FMOpt1:_UISr1:0:nvgpgl3_groupNode_risk_management\"]"));
			if(element.isDisplayed()==true) {
				test1.pass("Risk Management options displayed successfully.");
				
			}else {
				test1.fail("unable to display risk management option");
			}
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("src/test/java/step2screenshot.png"));
			driver.findElement(By.xpath("//*[@id=\"FMOpt1:_UISr1:0:nvcil2::icon\"]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"navmenu-container\"]/div[11]")).click();
			driver.findElement(By.xpath("//*[@id=\"itemNode_continuous_controls_management_controls\"]/svg")).click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("src/test/java/step3screenshot.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
