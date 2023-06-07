package com.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rgstpg {

	WebDriver ldriver;
	
	public rgstpg(WebDriver rdriver)
	{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="FirstName")
	WebElement firstname;
	
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(xpath="//h1[text()='Register']")
	WebElement logo;
	
	public void enterfirstname(String fN)
	{
		firstname.sendKeys(fN);
	}
	public void enterlastname(String LN)
	{
		lastname.sendKeys(LN);
	}
	public void enteremail(String EM)
	{
		email.sendKeys(EM);
	}
	public String logo()
	{
		String user=logo.getText();	
		return user;
	}
}
