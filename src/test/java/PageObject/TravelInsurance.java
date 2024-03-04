package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.Excel;

public class TravelInsurance extends Pageconstructor
{	
	JavascriptExecutor js;
	public TravelInsurance(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	@FindBy(xpath="//*[@class='icon-bg homeIconsBg icon-bg-new ti']") 
	WebElement travelInsurance;
	@FindBy(xpath="//input[@type='text']") 
	WebElement searchbox;
	@FindBy(xpath="//li[text()='France']") 
	WebElement selectcountry;
	@FindBy(xpath="//button[@class='travel_main_cta']") 
	WebElement proceed_date;
	@FindBy(xpath="(//input)[1][@class='MuiInputBase-input MuiOutlinedInput-input']") 
	WebElement startdate;
	@FindBy(xpath="(//input)[2][@class='MuiInputBase-input MuiOutlinedInput-input']") 
	WebElement enddate;
	@FindBy(xpath="//button[@class='travel_main_cta']") 
	WebElement proceed_trip;
	@FindBy(xpath="//label[@for='traveller_2']") 
	WebElement travellers;
	@FindBy(xpath="//div[@id=\"0\"][@class=\"customDropdown \"]") 
	WebElement traveller1;
	@FindBy(xpath="//label[text()='22 years']") 
	WebElement traveller1age;
	@FindBy(xpath="//div[@id=\"1\"][@class=\"customDropdown \"]") 
	WebElement traveller2;
	@FindBy(xpath="//label[text()='21 years']") 
	WebElement traveller2age;
	@FindBy(xpath="//button[@class='travel_main_cta']") 
	WebElement proceed_medical;
	@FindBy(xpath="//input[@id='ped_yes']") 
	WebElement selecting_yes;
	@FindBy(xpath="//input[@id='ped_yes_traveller_0']") 
	WebElement checkbox1;
	@FindBy(xpath="//input[@id='ped_yes_traveller_1']") 
	WebElement checkbox2;
	@FindBy(xpath="//button[@class='travel_main_cta']") 
	WebElement final_proceed;
	@FindBy(xpath="//input[@type='text']") 
	WebElement phone_num;
	@FindBy(xpath="//button[@class='travel_main_cta']") 
	WebElement viewplan;
	@FindBy(xpath="//input[@id='studentTrip']") 
	WebElement studentplan;
	@FindBy(xpath ="//*[@for ='Traveller_1']") 
	WebElement clickingtraveller1;
	@FindBy(css="input#Traveller_2") 
	WebElement clickingtraveller2;
	//@FindBy(xpath="//select[@id='feet']")
	@FindBy(xpath="//*[@id='feet']")
	WebElement tripduration;
	@FindBy(xpath="//button[@class='travel_main_cta'][text()='Apply']") 
	WebElement apply;
	@FindBy(xpath="//p[@class='filter_name_heading']") 
	WebElement sort;
	@FindBy(xpath="//input[@value='Premium low to high']") 
	WebElement sortprice;
	@FindBy(xpath="//p[@class='quotesCard--insurerName']") 
	List<WebElement> company;
	@FindBy(xpath="//span[@class='premiumPlanPrice']") 
	List<WebElement> price;
	//action
	public void clickTravelInsurance()
	{
		js.executeScript("arguments[0].click()", travelInsurance);
	}
	public void clickCountry() throws IOException
	{
		searchbox.click();
		searchbox.sendKeys(Excel.getcelldata("Sheet1", 1, 0));
	}
	public void clickCountryName()
	{
		 js.executeScript("arguments[0].click()", selectcountry);
	}
	public void clickproceeddate()
	{
		proceed_date.click();
	}
	public void EnterStartDate(String tripstartdate)
	{
		startdate.sendKeys(tripstartdate);
	}
	public void EnterEndDate(String tripenddate)
	{
		enddate.sendKeys(tripenddate);
	}
	public void clickproceedtravellers()
	{
		proceed_trip.click();
	}
	public void clickTravellers()
	{
		travellers.click();
	}
	public void clickTraveller1() throws InterruptedException
	{
		traveller1.click();
		Thread.sleep(2000);
	}
	public void selectTraveller1Age() throws InterruptedException
	{
		traveller1age.click();
		Thread.sleep(2000);
	}
	public void clickTraveller2() throws InterruptedException
	{
		traveller2.click();
		Thread.sleep(2000);
	}
	public void selectTraveller2Age() throws InterruptedException
	{
		traveller2age.click();
		Thread.sleep(2000);
	}
	public void clickproceedmedical()
	{
		js.executeScript("arguments[0].click()", proceed_medical);
	}
	public void clickyes()
	{
		selecting_yes.click();
	}
	public void selectTraveller1()
	{
		checkbox1.click();
	}
	public void selectTraveller2()
	{
		checkbox2.click();
	}
	public void selectfinalproceed()
	{
		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("arguments[0].click()", final_proceed);
	}
	public void Enterphone() throws IOException
	{
		phone_num.sendKeys(Excel.getcelldata("Sheet1", 1, 1));
	}
	public void clickviewplan()
	{
		viewplan.click();
	}
	public void selectStudentplan() throws InterruptedException
	{
		
		js.executeScript("arguments[0].click()", studentplan);
		Thread.sleep(2000);
	}
	public void selectTraveller1CheckBox() throws InterruptedException
	{
		
		js.executeScript("arguments[0].click()", clickingtraveller1);
		Thread.sleep(2000);
	}
	public void selectTraveller2CheckBox() throws InterruptedException
	{
		
		js.executeScript("arguments[0].click()", clickingtraveller2);
		Thread.sleep(2000);
	}
	public void selectTravelDuration()
	{
		Select drpdwn = new Select(tripduration);
		drpdwn.selectByValue("1");
	}
	public void clickApply() throws InterruptedException
	{
		
		js.executeScript("arguments[0].click()", apply);
	}
	public void sortFilter() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", sort);
	    }
	public void clickSortPrice() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", sortprice);
	}
	public void printCompanyName() throws IOException
	{
		List<String> companyname = new ArrayList<String>();
		   for(int i=0;i<3;i++) {
			   companyname.add(company.get(i).getText());
			   Excel.setcelldata("Sheet1",company.get(i).getText() , 0, i);
			   
		   }
		  System.out.println(companyname);
	}
	public void printPrices() throws InterruptedException, IOException
	{
		List<String> prices = new ArrayList<String>();
		   for(int i=0;i<3;i++) {
			   prices.add(price.get(i).getText());
			   Excel.setcelldata("Sheet1",price.get(i).getText() , 1, i);
			  
		   }
		   System.out.println(prices);
		   Thread.sleep(1000);
	}
	

}

