package com.odoo.ap.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{	
		String browsername = "Chrome";
		if(browsername.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) 
		{ 
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter valid browser");
		}
		driver.get("https://ap-automation.odoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
