package com.croma.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports xReports;
	ExtentTest xTest;

	  public void onStart(ITestContext testContext) {
		
		  String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String Repname= "Test-execution-report" + timeStamp + ".html";
		  String dest= System.getProperty("user.dir")+"/Reports/"+ Repname;
		  
		 htmlReporter =  new ExtentHtmlReporter(dest);
		 htmlReporter.config().setDocumentTitle("Automation Testing");
		 htmlReporter.config().setReportName("Functional Testing");
	     htmlReporter.config().setTheme(Theme.DARK);
	     htmlReporter.config().setAutoCreateRelativePathMedia(true);
	     
	     xReports= new ExtentReports();
	     xReports.attachReporter(htmlReporter);
	     xReports.setSystemInfo("hostname","localhost");
	     xReports.setSystemInfo("QA name","yashwanth");
	     xReports.setSystemInfo("OS","WINDOWS");
	     
		
	  }


	  public void onFinish(ITestContext testContext) {
	  xReports.flush();
	  }
	  
	  
      public void onTestSuccess(ITestResult tr) {
	      xTest= xReports.createTest(tr.getName());
	      xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	      xTest.log(Status.PASS,"Test is Passed");
	  }


	  public void onTestFailure(ITestResult tr) {
		  xTest= xReports.createTest(tr.getName());
		  xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	      xTest.log(Status.FAIL,"Test is failed");
	      xTest.log(Status.FAIL,tr.getThrowable());
	      
	      String path= System.getProperty("user.dir")+"/ScreenShots/" +tr.getName()+".png";
	      File file = new File(path);
	      if(file.exists())
	      {
	    	  try
	    	  {
	    		xTest.fail("screenshot for the faild test is:  "+ xTest.addScreenCaptureFromPath(path));  
	    	  }
	    	  catch(IOException e)
	    	  {
	    		  e.printStackTrace();
	    	  }
	      }
	  }


	  public void onTestSkipped(ITestResult tr) {
		  xTest= xReports.createTest(tr.getName());
		  xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	      xTest.log(Status.SKIP,"Test is skipped");
	      xTest.log(Status.SKIP,tr.getThrowable());
	  }
	

}
