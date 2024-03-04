package TestCases;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import TestBase.commonbase;


public class base {
		public static  WebDriver driver;
		public static Logger logger;
		public static Properties p;
		
		@BeforeTest(groups={"smoke","regression","master"})
		@Parameters({"os","browser"})
	    public void setup(String os,String br) throws IOException
		{
			commonbase b=new commonbase();
			driver=b.initializebrowser(os, br);
			logger=LogManager.getLogger(this.getClass());
		}
		public String screenshot(String name) 
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}
		@AfterTest(groups={"smoke","regression","master"})
		public void pageclose() {
			driver.quit();
		}

	}
