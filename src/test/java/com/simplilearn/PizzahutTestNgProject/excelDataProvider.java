package com.simplilearn.PizzahutTestNgProject;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class excelDataProvider {
	WebDriver driver;
	
	@Test(dataProvider = "test1Data")
	public void test1(String url) throws InterruptedException {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			ExtentTest test1 = extent.createTest("pizzahut page automation", "test to validate workflow ");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
	       //logger = extent.startTest("Validate pizzahutCheckout Application Using Selenium testNG");
			driver.manage().window().maximize();
			driver.get(url);
	       test1.log(Status.INFO, "pizzahut page opened");

		
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[7]/div/div/div/div/div/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		boolean element = driver.findElement(By.xpath("//*[@id=\"survicate-box\"]/div/div[2]/div[1]/div[1]/div[2]/button/svg")).isDisplayed();
//		System.out.println(element);
//		if (element= true){
//			driver.findElement(By.xpath("//*[@id=\"survicate-box\"]/div/div[2]/div[1]/div[1]/div[2]/button/svg")).click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/button")).click();
//		
//		}
		test1.pass("pop up removed");
//		else{
			try{
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys("lulu mall bangalore");
				test1.pass("able to put location");
			}catch(Exception e) {
			
				test1.fail("not avle to input location"+e.getCause());
			}
			//driver.findElement(By.xpath("//*[@id=\"survicate-box\"]/div/div[2]/div[1]/div[1]/div[2]/button/svg")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			//driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button/span/div")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			try {
				Assert.assertEquals(driver.getCurrentUrl(),"https://www.pizzahut.co.in/");
				test1.pass("user navigated to deals page");
			} catch (Exception e) {
				e.printStackTrace();
				test1.fail("not able to get deals page"+e.getCause());
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//selecting pizza
			try {
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]")).click();
				test1.pass("successfully able to open pizza tab ");
			} catch (Exception e) {
				e.printStackTrace();
				test1.fail("failed to navigate to pizza tab"+e.getCause());
			}
		//adding item below 200
//			String price = driver.findElement(By.className("w-auto ml-3")).getText();
//			System.out.println(price);
			try {
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[1]/div[3]/div/button")).click();
				boolean pizza = driver.findElement(By.xpath("//*[@id=\"basket\"]/div[3]/div/div[1]/div[1]")).isDisplayed();
				Assert.assertTrue(pizza);
				test1.pass("successfully added pizza "+pizza);
			} catch (Exception e) {
				e.printStackTrace();
				test1.fail("not able to add pizza"+e.getCause());
			}
			
			//navigate to drinks page
			try {
				driver.navigate().to("https://www.pizzahut.co.in/order/drinks/");
				test1.pass("successfully navigated to drinks page");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to navigated to drinks page"+e.getCause());
			}
			//selecting two drinks
			try {
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[1]/div[3]/div/button")).click();
				test1.pass("successfully added 1st drinks");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to add 1st drinks "+e.getCause());
			}
			try {
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[3]/div[3]/div/button")).click();
				test1.pass("successfully added 2nd drinks");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to add 2nd drinks "+e.getCause());
			}
			//click on checkout button
			try {
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")).click();
				Assert.assertEquals(driver.getCurrentUrl(), "https://www.pizzahut.co.in/order/checkout/");
				test1.pass("successfully navigated to checkout page by clicking checkout button");
			} catch (Exception e) {
				test1.fail("failed to go to checkout page"+e.getCause());
			}
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebElement element = driver.findElement(By.xpath("//*[@id=\"checkout-form\"]/div[4]/div[2]/label/div/div/span/span"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500); 
				boolean radioButton=driver.findElement(By.xpath("//*[@id=\"payment-method--razorpay\"]")).isSelected();
				Assert.assertTrue(radioButton, "radio button is default selected");
				test1.pass("radio button is defaulted selected");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("radio button not checked");
			}
			//check box default selected
			try {
				boolean checkBox = driver.findElement(By.className("checkbox")).isSelected();
				Assert.assertTrue(checkBox);
				test1.pass("check box already checked");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to check checkbox checked or not"+e.getMessage());
			}
			//entering mail name phone no
			try {
				driver.findElement(By.xpath("//*[@id=\"checkout__name\"]")).sendKeys("Souvik");
				driver.findElement(By.xpath("//*[@id=\"checkout__phone\"]")).sendKeys("9732378865");
				driver.findElement(By.xpath("//*[@id=\"checkout__email\"]")).sendKeys("john@example.com");
				test1.pass("successfully added name number email");
			}catch(Exception e) {
				test1.fail("failed to add details"+e.getMessage());
			}
			//click on add gift card
			try {
				driver.findElement(By.xpath("//*[@id=\"checkout-form\"]/div[3]/button")).click();
				test1.pass("successfully clicked on gift card");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to click on gift card");
			}
			//popup
			try {
				boolean popup=driver.findElement(By.xpath("/html/body/div[7]/div/div/div")).isDisplayed();
				Assert.assertTrue(popup, "popup is displayed");
				test1.pass("successfully vaildated popup");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to validate popup");
			}
			try {
				//click on voucher
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[1]/div[1]")).click();
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[2]/form/input")).sendKeys("12345");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[2]/form/div[2]/button[1]")).submit();
				test1.pass("successfuuly click on voucher and submit code");
			} catch (Exception e) {
				// TODO: handle exception
				test1.fail("failed to validating voucher part");
			}
			try{//validating error
				Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[2]/form/div[2]")).isDisplayed());
				test1.pass("got the error coupon code message");
			}catch(Exception e) {
				test1.fail("not getting any error code working order pizza now");
			}
			try{//close pop up
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/button")).click();
				test1.pass("successfully closed the voucher popup");
			}catch(Exception e) {
				test1.fail("failed to close voucher popup");
			}
			
			try{//user navigate to basket page
				String basket= driver.findElement(By.xpath("//*[@id=\"basket\"]/h2")).getText();
				Assert.assertEquals(basket, "Your Basket");
				test1.pass("successfully navigated to basket page");
			}catch(Exception e) {
				test1.fail("failed test");
			}
			
		
//		}
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		
	}
	public static void main(String[] args) {
		String excelPath="C:\\Users\\svksh\\eclipse-workspace\\excelTestng\\src\\test\\excel\\excel.xlsx";
		String sheetname="Sheet2";
		testData(excelPath,sheetname);
	}
	@DataProvider(name="test1Data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\svksh\\eclipse-workspace\\excelTestng\\src\\test\\excel\\excel.xlsx";
		String sheetname= "Sheet2";
		Object data[][]=testData(excelPath, sheetname);
		return data;
		
	}
	public static Object[][] testData(String excelPath, String sheetname) {
		excelUtils excel = new excelUtils(excelPath, sheetname);
		int row = excel.getRowCount();
		int col = excel.getColCount();
		Object data[][] = new Object[row-1][col];
		for(int i=1;i<row;i++) {
			for(int j =0; j<col;j++) {
				String cellData=excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
	}

}
