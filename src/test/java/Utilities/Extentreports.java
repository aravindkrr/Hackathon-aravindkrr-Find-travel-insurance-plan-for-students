package Utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.base;

public class Extentreports implements ITestListener{
	
		public ExtentSparkReporter sparkReporter; 
		public ExtentReports extent;
		public ExtentTest test;
		String reportname;

		public void onStart(ITestContext context) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy,MM,dd ; HH.mm.ss");
			Date dt=new Date();
			String timestamp=sdf.format(dt);
			reportname="Test_Report" + timestamp +".html";
			sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+reportname);
			
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Hackathon Project");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Project Title","Insurance Plans");
			extent.setSystemInfo("Computer","local");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Tester Name","Aravind");
			String os=context.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System",os);
			String browser=context.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser",browser);
			List<String> groups=context.getCurrentXmlTest().getIncludedGroups();
			if(!groups.isEmpty()) {
				extent.setSystemInfo("Groups",groups.toString());
			}
						
		}


		public void onTestSuccess(ITestResult result) {
			
			test = extent.createTest(result.getName()); // create a new entry in the report
			test.log(Status.PASS,result.getName() + "is PASSED"); // update status p/f/s
			String imgPath = new base().screenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}

		public void onTestFailure(ITestResult result) {
			
			test = extent.createTest(result.getName());
			test.log(Status.FAIL,result.getName() + "is FAILED");
			test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
			String imgPath = new base().screenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
						
		}

		public void onTestSkipped(ITestResult result) {

			test = extent.createTest(result.getName());
			test.log(Status.SKIP, result.getName() + "is SKIPPED" );
			
		}

		
		public void onFinish(ITestContext context) {
			
			extent.flush();
			String reportpath=System.getProperty("user.dir")+ "/reports/"+reportname;
			File extentReport=new File(reportpath);
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
			
		
	}