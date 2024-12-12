package com.simplilearn.TestNgDemos;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotControl {
	TakesScreenshot camera;
	
	ScreenShotControl(WebDriver driver){
		camera = (TakesScreenshot)driver;
		
	}
	

	public void captureAndSaveScreenshot(String pathFile) throws Exception{
		
		pathFile = pathFile.trim();
		File imgFile, tmpFile;
		imgFile = new File(pathFile);
		
		if(imgFile.exists()) {
			throw new Exception("Image with this file already exists");
			
		}
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile,imgFile);
	}

}
