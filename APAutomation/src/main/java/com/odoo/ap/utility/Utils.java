package com.odoo.ap.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.odoo.ap.testbase.TestBase;

public class Utils extends TestBase {

	public static void captureScreenshot(String filename)
	{
		try 
		{
			String path = "C:\\Users\\User\\eclipse-workspace\\ApautomationFremwork5\\screenshots\\";		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path + filename +".png");	
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
