package com.odoo.ap.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUIstep {
	
	private WebDriver driver;
	public CommonUIstep(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//-----------------------------------------------\\
	
	private By error_message_text = By.xpath("//p[@class='alert alert-danger']");
	
	public String getErrorMessageFromPage()
	{
		String message = driver.findElement(error_message_text).getText();
		return message;
	}

}
