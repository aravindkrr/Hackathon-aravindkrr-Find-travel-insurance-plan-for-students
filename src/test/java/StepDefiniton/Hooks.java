package StepDefiniton;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.commonbase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	public static Properties p;
@BeforeAll
public static void launchbrowser() throws IOException {
	commonbase b=new commonbase();
	FileReader file=new FileReader(".//src//test//resources//config.properties");
	 p=new Properties();
	 p.load(file);
	driver=b.initializebrowser(p.getProperty("os"), p.getProperty("br"));
	driver.manage().window().maximize();
}
@AfterStep
public void addScreenshot(Scenario scenario) {
//    if(scenario.isFailed()) {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
    	            
    }

@AfterAll
public static void teardown()
{
	driver.quit();
}
}