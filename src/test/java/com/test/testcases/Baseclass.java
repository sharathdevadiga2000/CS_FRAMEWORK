package com.test.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.test.utility.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Baseclass {

	Readconfig readconfig=new Readconfig();
	 String url=readconfig.getbaseurl();
	 String browser=readconfig.getbrowser();
	 
	 public static WebDriver driver;
@BeforeClass	 
	public void setup()
	{
		
		switch (browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
default:
	driver=null;
	break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
       
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.manage().window().maximize();
	
	}
	
	
	
	
	public void capturescreenshot(WebDriver driver,String testname ) throws IOException
	{
		TakesScreenshot sht= (TakesScreenshot)driver;
		File src =sht.getScreenshotAs(OutputType. FILE);
		File trg=new File(System.getProperty("user.dir")+"\\screenshot"+testname+".png");
		FileUtils.copyFile(src, trg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
