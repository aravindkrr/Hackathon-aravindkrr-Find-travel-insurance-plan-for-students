package Smoke;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import PageObject.CarInsurance;
import PageObject.HealthInsurance;
import PageObject.TravelInsurance;
import TestCases.base;
import Utilities.Datepickers;

public class SmokeTest extends base {

	TravelInsurance travel;
	CarInsurance car;
	HealthInsurance health;
	@Test(priority = 1)
	public void countrydetails() throws InterruptedException, IOException{
	
		logger.info("Starting Smoke Testing");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		travel = new TravelInsurance(driver);
		travel.clickTravelInsurance();
		travel.clickCountry();
		travel.clickCountryName();
		travel.clickproceeddate();
		}
	@Test(priority = 2)
	public void tripdates() throws InterruptedException, IOException {
		travel.EnterStartDate(Datepickers.startdate());
	    travel.EnterEndDate(Datepickers.enddate());
		travel.clickproceedtravellers();
	}
	@Test(priority = 3)
	public void travellerage() throws InterruptedException, IOException {
		travel.clickTravellers();
		travel.clickTraveller1();
		travel.selectTraveller1Age();
		travel.clickTraveller2();
		travel.selectTraveller2Age();
		travel.clickproceedmedical();
	}
	@Test(priority = 4)
	public void medicaldetails() throws InterruptedException, IOException {
		travel.clickyes();	
		travel.selectTraveller1();
		travel.selectTraveller2();
		travel.selectfinalproceed();
		}
	@Test(priority = 5)
	public void homePage() throws InterruptedException {
		car= new CarInsurance(driver);
		car.NavigateBack();
		}
	@Test(priority = 6)
	public void carinsurancepage() throws InterruptedException, IOException {
		car.clickMenu();
		car.clickCarInsurance();
		car.clickProceed();
	}
	@Test(priority = 7)
	public void navigateHomePage() throws InterruptedException {
		health=new HealthInsurance(driver);
		health.HomePage();
	}
	
	@Test(priority = 8)
	public void clickproduct() {
		health.insuranceproducts();
		logger.info("Ending Smoke Testing");
		}
}
