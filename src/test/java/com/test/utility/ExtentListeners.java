package com.test.utility;

	import java.io.File;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentListeners implements ITestListener {
		
		ExtentSparkReporter htmlreporter;
		ExtentReports reports;
		ExtentTest test;
		
		public void configreport()
		{
			htmlreporter =new ExtentSparkReporter("extent report");
	        reports=new ExtentReports();
	        reports.attachReporter(htmlreporter);
	        
	        //add environments
	        
	        reports.setSystemInfo("machine", "testpc 2");
	        reports.setSystemInfo("OS","window10");
	        reports.setSystemInfo("browser", "chrome");
	        reports.setSystemInfo("user", "sharath");
	        
	        //change look and feel 
	        
	        htmlreporter.config().setDocumentTitle("TEST REPORT");
	        htmlreporter.config().setReportName("sharath report");
	        htmlreporter.config().setTheme(Theme.DARK);
	        
	    }
		public void onstart(ITestContext Result)
		{
		    configreport();
		    System.out.println("The executio has started");
			
		}
		public void onFinish(ITestContext Result)
		{
			System.out.println("on finish method has invoked");
			reports.flush();
		}
		public void onTestfailure(ITestResult Result)
		{
			System.out.println("name of the tset case failed: "+Result.getName());
			test=reports.createTest(Result.getName());
		     test.log(Status.FAIL, MarkupHelper.createLabel("Name of he failed test case:  " + Result.getName(),ExtentColor.RED  ));
		
		     String screenshotpath=System.getProperty("user.dir")+ "\\screenshot\\"+ Result.getName()+ ".png"; 
		     
		     File Screenshotfile=new File(screenshotpath);
		if(Screenshotfile.exists())
		{
			test.fail("test is already failed :"+test.addScreenCaptureFromPath(screenshotpath)); 
		}
		
		//test.addScreenCaptureFromPath(null)
		
		
		
		}
		
		public void onTestSkipped(ITestResult Result)
		{
			test=reports.createTest(Result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped testcase: "+Result.getName(), ExtentColor.BLUE));
		}
		public void onTeststart(ITestResult Result)
		{
			System.out.println("test has started: "+ Result.getName());
			
		}
		public void onTestSuccess(ITestResult Result)
		{
		     test=reports.createTest(Result.getName());
		     test.log(Status.PASS,MarkupHelper.createLabel("Name of the pass test: "+ Result.getName(),ExtentColor.YELLOW));
		}
		public void onTestFailedButWithSuccesPercentage(ITestResult Result)
		{
			
		}
		
		
		
	}





