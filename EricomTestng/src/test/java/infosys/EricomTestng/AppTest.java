package infosys.EricomTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*    Custom Xpaths:It is always possible to design your own relative xpath by using different attributes of the Web Element.            
							Syntax: //tag_name[@attribute='value']				*/

public class AppTest {
	WebDriver driver;
	takeSnapShot takesnapshot;
	@Parameters({"SaseUsername","password"})
	@Test(priority = 1)
	public void EricomSASETenent(String username,String password) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		takesnapshot = new takeSnapShot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://ztadmin.ericomcloud.net/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/add-user-dialog/div[2]/button")).click();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.5'");
		Thread.sleep(10000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\dashboard.png");
		
		
		//session per day
		WebElement SessionPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div"));
		//WebElement SessionPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[2]/app-sessions-per-day-bar-chart/div/app-bar-chart/div/div[1]/svg"));
		Actions action = new Actions(driver);
		action.moveToElement(SessionPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\SessionPerDay.png");
		//action.moveToElement(SessionPerDayZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Minutes perday
		WebElement MinutesPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div"));
		WebElement MinutesPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div"));
		action.moveToElement(MinutesPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\MinutesPerDay.png");
		//action.moveToElement(MinutesPerDayZoomIn).build().perform();
		//WebElement stale = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon"));
		//wait.until(ExpectedConditions.stalenessOf(stale));
		//wait.until(ExpectedConditions.stalenessOf(MinutesPerDayZoomIn));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")));
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Domain Session Percentage
		WebElement DomainSessionPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div"));
		WebElement DomainSessionPercentageZoomIn= driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(DomainSessionPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\DomainSessionPercentage.png");
		//action.moveToElement(DomainSessionPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Browser percentage
		WebElement BrowserPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div"));
		WebElement BrowserPercentageZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(BrowserPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\BrowserPercentage.png");
		//action.moveToElement(BrowserPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//SessionPerPoP percentage
		WebElement SessionPerPoPpercentage = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div"));
		action.moveToElement(SessionPerPoPpercentage).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div/div[1]/button/span[1]/mat-icon")).click();
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\SessionPerPoPpercentage.png");
		
	
		
	}
	@Test(priority = 2)
	@Parameters({"InfosysBUsername","password"})
	public void infosysBTenent(String username,String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		takesnapshot = new takeSnapShot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://ztadmin.ericomcloud.net/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/add-user-dialog/div[2]/button")).click();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.5'");
		Thread.sleep(10000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBdashboard.png");
		
		
		//session per day
		WebElement SessionPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div"));
		//WebElement SessionPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[2]/app-sessions-per-day-bar-chart/div/app-bar-chart/div/div[1]/svg"));
		Actions action = new Actions(driver);
		action.moveToElement(SessionPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBSessionPerDay.png");
		//action.moveToElement(SessionPerDayZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Minutes perday
		WebElement MinutesPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div"));
		WebElement MinutesPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div"));
		action.moveToElement(MinutesPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBMinutesPerDay.png");
		//action.moveToElement(MinutesPerDayZoomIn).build().perform();
		//WebElement stale = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon"));
		//wait.until(ExpectedConditions.stalenessOf(stale));
		//wait.until(ExpectedConditions.stalenessOf(MinutesPerDayZoomIn));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")));
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Domain Session Percentage
		WebElement DomainSessionPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div"));
		WebElement DomainSessionPercentageZoomIn= driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(DomainSessionPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBDomainSessionPercentage.png");
		//action.moveToElement(DomainSessionPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Browser percentage
		WebElement BrowserPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div"));
		WebElement BrowserPercentageZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(BrowserPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBBrowserPercentage.png");
		//action.moveToElement(BrowserPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//SessionPerPoP percentage
		WebElement SessionPerPoPpercentage = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div"));
		action.moveToElement(SessionPerPoPpercentage).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div/div[1]/button/span[1]/mat-icon")).click();
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBSessionPerPoPpercentage.png");
		
	}
	@Test(priority =3)
	@Parameters({"InfosysCTenent","password"})
	public void InfosysCTenent(String username, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		takesnapshot = new takeSnapShot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://ztadmin.ericomcloud.net/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/add-user-dialog/div[2]/button")).click();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.5'");
		Thread.sleep(10000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCdashboard.png");
		
		
		//session per day
		WebElement SessionPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div"));
		//WebElement SessionPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[2]/app-sessions-per-day-bar-chart/div/app-bar-chart/div/div[1]/svg"));
		Actions action = new Actions(driver);
		action.moveToElement(SessionPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCSessionPerDay.png");
		//action.moveToElement(SessionPerDayZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Minutes perday
		WebElement MinutesPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div"));
		WebElement MinutesPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div"));
		action.moveToElement(MinutesPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCMinutesPerDay.png");
		//action.moveToElement(MinutesPerDayZoomIn).build().perform();
		//WebElement stale = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon"));
		//wait.until(ExpectedConditions.stalenessOf(stale));
		//wait.until(ExpectedConditions.stalenessOf(MinutesPerDayZoomIn));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")));
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Domain Session Percentage
		WebElement DomainSessionPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div"));
		WebElement DomainSessionPercentageZoomIn= driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(DomainSessionPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCDomainSessionPercentage.png");
		//action.moveToElement(DomainSessionPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Browser percentage
		WebElement BrowserPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div"));
		WebElement BrowserPercentageZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(BrowserPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCBrowserPercentage.png");
		//action.moveToElement(BrowserPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//SessionPerPoP percentage
		WebElement SessionPerPoPpercentage = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div"));
		action.moveToElement(SessionPerPoPpercentage).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div/div[1]/button/span[1]/mat-icon")).click();
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysCSessionPerPoPpercentage.png");
	}
	@Test(priority =4)
	@Parameters({"InfosysTenent","password"})
	public void IremoteTenent(String username, String password) throws Exception{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		takesnapshot = new takeSnapShot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://ztadmin.ericomcloud.net/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/fieldset[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/section/div/div/div/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/add-user-dialog/div[2]/button")).click();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.5'");
		Thread.sleep(10000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysDashboard.png");
		
		
		//session per day
		WebElement SessionPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div"));
		//WebElement SessionPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[2]/app-sessions-per-day-bar-chart/div/app-bar-chart/div/div[1]/svg"));
		Actions action = new Actions(driver);
		action.moveToElement(SessionPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[1]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysSessionPerDay.png");
		//action.moveToElement(SessionPerDayZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Minutes perday
		WebElement MinutesPerDayZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div"));
		WebElement MinutesPerDayZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div"));
		action.moveToElement(MinutesPerDayZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[2]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysMinutesPerDay.png");
		//action.moveToElement(MinutesPerDayZoomIn).build().perform();
		//WebElement stale = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon"));
		//wait.until(ExpectedConditions.stalenessOf(stale));
		//wait.until(ExpectedConditions.stalenessOf(MinutesPerDayZoomIn));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")));
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Domain Session Percentage
		WebElement DomainSessionPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div"));
		WebElement DomainSessionPercentageZoomIn= driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(DomainSessionPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[3]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysDomainSessionPercentage.png");
		//action.moveToElement(DomainSessionPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//Browser percentage
		WebElement BrowserPercentageZoomOut = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div"));
		WebElement BrowserPercentageZoomIn = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div"));
		action.moveToElement(BrowserPercentageZoomOut).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[4]/div/div[1]/button/span[1]/mat-icon")).click();
		Thread.sleep(5000);
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysBrowserPercentage.png");
		//action.moveToElement(BrowserPercentageZoomIn).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div/div[1]/button/span[1]/mat-icon")).click();
		
		
		//SessionPerPoP percentage
		WebElement SessionPerPoPpercentage = driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div"));
		action.moveToElement(SessionPerPoPpercentage).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/app-frame/div[1]/div[2]/app-shield-dashboard/div/div/div[5]/div/div[1]/button/span[1]/mat-icon")).click();
		takesnapshot.takeSnapShot1(driver, "C:\\Users\\svksh\\eclipse-workspace\\EricomTestng\\snapshot\\InfosysSessionPerPoPpercentage.png");
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
}
