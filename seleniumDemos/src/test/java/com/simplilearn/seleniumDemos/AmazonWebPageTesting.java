package com.simplilearn.seleniumDemos;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWebPageTesting {
	
	@Test
	public void testHomepage() throws InterruptedException, IOException{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C://Users//svksh//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		//String currentUrl = "https://www.amazon.com/";
		//driver.getCurrentUrl().contains(currentUrl)
		
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone15");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		

		//js.executeScript("window.scrollBy(0,-500)");
		//WebElement signInElement = driver.findElement(By.xpath("//*[@id=\"CardInstanceqK2q_AI0POfe7091G_FHuw\"]/div/div/a/span"));
		//js.executeScript("arguments[0].scrollIntoView(true);", signInElement);
		//signInElement.click();
		//Thread.sleep(500);
		//js.executeScript("window.scrollBy(0,500)");
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signInElement);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,14000)");
		driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[7]/ul/li[2]/a")).click();
		//hover
		WebElement hover = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("svkshrm@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"legalTextRow\"]/a[1]")).click();
		//need to invoke screenshot method to take screenshot  of user acceptance
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Souvik99@");
		driver.findElement(By.xpath("//*[@id=\"remember_me_learn_more_link\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		Thread.sleep(1000);
		TakesScreenshot scr = (TakesScreenshot)driver;
		   
		   // Saving the screenshot in this
		   File src = scr.getScreenshotAs(OutputType.FILE);
		 
		   
		   File dest = new File("C:\\Users\\svksh\\OneDrive\\Desktop\\Amazon.png");
		   FileUtils.copyFile(src,dest);
		   System.out.println("driver too screenshot");
		   
		   driver.navigate().to("https://www.amazon.com/");
		   //perform dropdown list
		   driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("tshirt");
		   driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   WebElement findShirt = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[15]/div/div/span/div/div/div[1]/span/a/div/img"));
		   js.executeScript("arguments[0].scrollIntoView(true)", findShirt);
		   findShirt.click();
		   WebElement selectSize = driver.findElement(By.xpath("//select[@id =\"native_dropdown_selected_size_name\"]"));
		   Select select = new Select(selectSize);
		   select.selectByIndex(2);
		   
		   
	}		
		//taking screenshot
	


}
