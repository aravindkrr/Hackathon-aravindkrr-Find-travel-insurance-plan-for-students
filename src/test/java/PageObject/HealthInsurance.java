package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Excel;

public class HealthInsurance extends Pageconstructor{
	public HealthInsurance(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//i[@class=\"arrow\"]") 
	WebElement products;
	@FindBy(xpath="//*[@class=\"ruby-col-3 hidden-md\"][2]/ul/li") 
	List<WebElement> insuranceplans;
	

	public void HomePage() throws InterruptedException {
		driver.navigate().to("https://www.policybazaar.com/");
		Thread.sleep(1000);
		}
	public void insuranceproducts()
	{
		products.click();
	}
	public void healthInsuranceProducts() throws IOException
	{
		for(int i=0;i<insuranceplans.size();i++) {
		String plans = insuranceplans.get(i).getText();
		System.out.println(plans);
		Excel.setcelldata("Sheet1", plans, i+3, 0);
		}
	}
}

