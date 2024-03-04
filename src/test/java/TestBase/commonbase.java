package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class commonbase {
	public static  WebDriver driver;
	static Logger logger;
	public static Properties p;
	public WebDriver initializebrowser(String os,String br) throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 {
			 DesiredCapabilities capabilities=new DesiredCapabilities();
			 //os
			 if(os.equalsIgnoreCase("windows"))
			 {
				 capabilities.setPlatform(Platform.WIN11);
			 }
			 else if(os.equalsIgnoreCase("mac"))
			 {
				 capabilities.setPlatform(Platform.MAC);
				 }
			 else
			 {
				 System.out.println("No matching os..");
				 driver=null;
			 }
			 //browser
			 switch(br.toLowerCase())
			 {
			 case "chrome" : capabilities.setBrowserName("chrome");
			 break;
			 case "edge" : capabilities.setBrowserName("edge");
			 break;
			 case "firefox" : capabilities.setBrowserName("firefox");
			 break;
			 default: System.out.println("No matching browser..");
			 driver=null;
			 }
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get(p.getProperty("url"));
	
    }
		 else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
				 if(br.equalsIgnoreCase("chrome")) {
				 driver = new ChromeDriver();
			     driver.manage().deleteAllCookies();
			     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     driver.manage().window().maximize();
			     driver.get(p.getProperty("url"));
			     }
			 else if(br.equalsIgnoreCase("edge")) {
				 driver = new EdgeDriver();
				 driver.manage().deleteAllCookies();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 driver.manage().window().maximize();
				 driver.get(p.getProperty("url"));
				 }
			 else if(br.equalsIgnoreCase("firefox")) {
				 driver = new FirefoxDriver();
				 driver.manage().deleteAllCookies();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 driver.manage().window().maximize();
				 driver.get(p.getProperty("url"));
				 }
			 }
		 return driver;
	}
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}

}
