package ExtentReportfile;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class Extent {

	//first create a variable of extent class
	ExtentSparkReporter htmlreporter;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void startreport()
	{
	 htmlreporter=new ExtentSparkReporter("ExtentReportfile.Html");
	 report=new ExtentReports();
	 report.attachReporter(htmlreporter);
	 
	 //add environment
	 
	report.setSystemInfo("machine", "testpc");
	report.setSystemInfo("OS", "windows11");
	 report.setSystemInfo("user", "sharath");
	 report.setSystemInfo("browser", "chrome");
	 
	 //configure to change the look and feel 
	 htmlreporter.config().setDocumentTitle("Extentreport");
	 htmlreporter.config().setReportName("testreport");
	 htmlreporter.config().setTheme(Theme.STANDARD);
	 htmlreporter.config().setTimeStampFormat("EEE, MMM dd , yyyy , hh:mm a '('zzz')'");
	}

	@Test
	public void verifylaunchbrowser()
	{
		test=report.createTest("Browser Launched");
		Assert.assertTrue(true);
		
	}
	@Test
	 public void verifytest()
	 {
		 test=report.createTest("gjverify test");
		 Assert.assertTrue(true);
	 }
	@Test
	 public void verifylogin()
	 {
		 test=report.createTest("uuiiverify Login");
		 Assert.assertTrue(false);
	 }
	@Test
	 public void verifyemail()
	 {
		 test=report.createTest("verifyemail");
         throw new SkipException("skkiped");		 
	 }
	 
	 //now you have to create the aftertestmethod 
	 @AfterMethod
	 public void gettestresult(ITestResult result)
	 {
		 if(result.getStatus()==ITestResult.FAILURE)
		 {
			 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "fail",ExtentColor.AMBER));
	          test.fail(result.getThrowable());	 
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 test.log(Status.PASS,MarkupHelper.createLabel(result.getName() +"Pass",ExtentColor.BLUE));
			 
		 }
		 else if(result.getStatus()==ITestResult.SKIP)
	 
	 {
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() +"skipped", ExtentColor.GREEN));	 
	 }
		 }
	 @AfterTest
	 public void teatdown()
	 {
		 report.flush();
	 }
	 
	 
	 
	}



