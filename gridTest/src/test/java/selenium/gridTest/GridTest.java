package com.simplilearn.TestNgDemos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	DesiredCapabilities dc;
	WebDriver driver;
	@Test
	public void test() throws InterruptedException {
		dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN11);
		
		try {
			System.out.println("Test starts ....");
			driver = new RemoteWebDriver(new URL("http://192.168.0.206:4444"),dc);
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in/");
			System.out.println("title of the page is"+driver.getTitle());
			Thread.sleep(5000);
			driver.quit();
			System.out.println("Test ended ...");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		
	}
	@Test
	public void test1() throws InterruptedException {
		dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN11);
		
		try {
			System.out.println("Test1 starts ....");
			driver = new RemoteWebDriver(new URL("http://192.168.0.206:4444"),dc);
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in/");
			System.out.println("title of the page is"+driver.getTitle());
			Thread.sleep(5000);
			driver.quit();
			System.out.println("Test1 ended ...");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		
	}
	@Test
	public void test2() throws InterruptedException {
		dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN11);
		
		try {
			System.out.println("Test2 starts ....");
			driver = new RemoteWebDriver(new URL("http://192.168.0.206:4444"),dc);
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in/");
			System.out.println("title of the page is"+driver.getTitle());
			Thread.sleep(5000);
			driver.quit();
			System.out.println("Test ended2 ...");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		
	}

}
