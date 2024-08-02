package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathAxes {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\simplilearn\\New folder\\example.html");
		driver.manage().window().maximize();
		//child
		WebElement childEle = driver.findElement(By.xpath("//select//child::option[4]"));
		childEle.click();
		
		//parent
		WebElement parentEle = driver.findElement(By.xpath("//select[@option='Jan']//parent::select"));
		
		
	}

}
