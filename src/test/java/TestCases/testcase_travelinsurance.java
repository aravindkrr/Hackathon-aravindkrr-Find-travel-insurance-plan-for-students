package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import PageObject.TravelInsurance;

import Utilities.Datepickers;

public class testcase_travelinsurance extends base {
	TravelInsurance travel;
	@Test(priority = 1,groups={"smoke","regression"})
	public void countrydetails() throws InterruptedException, IOException{
	
		logger.info("Starting testcase_travelinsurance");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		travel = new TravelInsurance(driver);
		logger.info("Entering Students TravelInsurance Plan Details");
		travel.clickTravelInsurance();
		travel.clickCountry();
		travel.clickCountryName();
		travel.clickproceeddate();
		}
	@Test(priority = 2,groups={"smoke","regression"})
	public void tripdates() throws InterruptedException, IOException {
		travel.EnterStartDate(Datepickers.startdate());
	    travel.EnterEndDate(Datepickers.enddate());
		travel.clickproceedtravellers();
	}
	@Test(priority = 3,groups={"smoke","regression"})
	public void travellerage() throws InterruptedException, IOException {
		travel.clickTravellers();
		travel.clickTraveller1();
		travel.selectTraveller1Age();
		travel.clickTraveller2();
		travel.selectTraveller2Age();
		travel.clickproceedmedical();
	}
	@Test(priority = 4,groups={"smoke","regression"})
	public void medicaldetails() throws InterruptedException, IOException {
		travel.clickyes();	
		travel.selectTraveller1();
		travel.selectTraveller2();
		travel.selectfinalproceed();
		}
	@Test(priority = 5,groups={"regression"})
	public void Enteringphone() throws InterruptedException, IOException {
		travel.Enterphone();
		travel.clickviewplan();
		
	}
	@Test(priority = 6,groups={"regression"})
	public void plantype() throws InterruptedException, IOException {
		travel.selectStudentplan();
		
	}
	@Test(priority = 7,groups={"regression"})
	public void studentinfo() throws InterruptedException, IOException {
		travel.selectTraveller1CheckBox();
		travel.selectTraveller2CheckBox();
		
	}
	@Test(priority = 8,groups={"regression"})
	public void tripduration() throws InterruptedException, IOException {
		travel.selectTravelDuration();
		travel.clickApply();
		
	}
	@Test(priority = 9,groups={"regression"})
	public void addingfilter() throws InterruptedException, IOException {
		travel.sortFilter();
		travel.clickSortPrice();
		
	}
	@Test(priority = 10,groups={"regression"})
	public void InsurancePlans() throws InterruptedException, IOException {
		travel.printCompanyName();
		travel.printPrices();
		logger.info("Ending testcase_travelinsurance");
		
	}

}