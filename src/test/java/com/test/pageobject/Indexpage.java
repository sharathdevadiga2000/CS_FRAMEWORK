package com.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Indexpage {

	WebDriver ldriver;
	
	public Indexpage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
@FindBy(linkText ="Register")
WebElement register;
	
	public void clickregister()
	{
		register.click();
	}
	
}
