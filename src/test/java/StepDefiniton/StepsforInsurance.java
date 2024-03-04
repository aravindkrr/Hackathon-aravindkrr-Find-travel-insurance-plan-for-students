package StepDefiniton;

import java.io.IOException;
import PageObject.CarInsurance;
import PageObject.HealthInsurance;
import PageObject.TravelInsurance;
import TestBase.commonbase;
import Utilities.Datepickers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsforInsurance extends commonbase{
	TravelInsurance travelinsu = new TravelInsurance(driver);
	CarInsurance carinsu = new CarInsurance(driver);
	HealthInsurance healthinsu = new HealthInsurance(driver);
	
	@Given("User is on the insurance website")
	public void user_is_on_the_insurance_website() throws IOException {
		travelinsu.clickTravelInsurance();
	}
	@When("User enters the studentInsurance Details")
	public void user_enters_the_student_insurance_details() throws InterruptedException, IOException {
		getLogger().info("Starting Cucumber Framework");
		getLogger().info("Regression Testing is Started");
		getLogger().info("Started Travel Insurance");
		getLogger().info("Entering Student Details");
		travelinsu.clickCountry();
		travelinsu.clickCountryName();
		travelinsu.clickproceeddate();
		travelinsu.EnterStartDate(Datepickers.startdate());
		travelinsu.EnterEndDate(Datepickers.enddate());
		travelinsu.clickproceedtravellers();
		travelinsu.clickTravellers();
		travelinsu.clickTraveller1();
		travelinsu.selectTraveller1Age();
		travelinsu.clickTraveller2();
		travelinsu.selectTraveller2Age();
		travelinsu.clickproceedmedical();
		travelinsu.clickyes();
		travelinsu.selectTraveller1();
		travelinsu.selectTraveller2();
		travelinsu.selectfinalproceed();
		travelinsu.Enterphone();
		travelinsu.clickviewplan();
		travelinsu.selectStudentplan();
		travelinsu.selectTraveller1CheckBox();
		travelinsu.selectTraveller2CheckBox();
		travelinsu.selectTravelDuration();
		travelinsu.clickApply();
		travelinsu.sortFilter();
		travelinsu.clickSortPrice();
		}

	@Then("Display the Top {int} Lowest Insurance Plans")
	public void display_the_top_lowest_insurance_plans(Integer int1) throws InterruptedException, IOException {
		travelinsu.printCompanyName();
		travelinsu.printPrices();
		getLogger().info("Ended Travel Insurace");
	}
	
	@Given("User navigates to car insurance Page")
	public void user_navigates_to_car_insurance_page() throws InterruptedException {
		carinsu.NavigateBack();  
		getLogger().info("Started Car Insurace");
	}
	@When("User provides car Insurance Details")
	public void user_provides_car_insurance_details() throws InterruptedException, IOException {
		carinsu.clickMenu();
		carinsu.clickCarInsurance();
		carinsu.clickProceed();
		getLogger().info("Entering Car Details");
		carinsu.clickCityName();
		carinsu.clickRTO();
		carinsu.clickCarBrand();
		carinsu.clickCarModel();
		carinsu.clickFuelType();
		carinsu.clickVarient();
		
	}
	@Then("Display the Error Message")
	public void display_the_error_message() throws IOException, InterruptedException {
		carinsu.EnterAnyName();
		carinsu.EnterIncorrectEmail();
		carinsu.clickEnterButton();
		getLogger().info("Capturing Error Message");
		carinsu.PrintErrorMessage();
		getLogger().info("Ended Car Insurace");
		}
	
	@Given("User Navigates to HomePage")
	public void user_navigates_to_home_page() throws InterruptedException {
		healthinsu.HomePage();
		getLogger().info("Started Health Insurace");
		}
	@When("User clicks on Insurance Products")
	public void user_clicks_on_insurance_products() {
		healthinsu.insuranceproducts();
	}
	@Then("Display the List of Insurance Items List")
	public void display_the_list_of_insurance_items_list() throws IOException {
		healthinsu.healthInsuranceProducts();
		getLogger().info("Displaying Health Plans");
		getLogger().info("Ended Health Insurace");
		getLogger().info("Regression Testing is Ended");
		getLogger().info("Ending Cucumber Framework");
	}
	
	//Smoke Testing
	@Given("User Navigates to insurance page")
	public void user_navigates_to_insurance_page() {
		getLogger().info("Stating Smoke Testing");
		travelinsu.clickTravelInsurance();
	}
	@When("User enters student details")
	public void user_enters_student_details() throws InterruptedException, IOException {
		travelinsu.clickCountry();
		travelinsu.clickCountryName();
		travelinsu.clickproceeddate();
		travelinsu.EnterStartDate(Datepickers.startdate());
	    travelinsu.EnterEndDate(Datepickers.enddate());
		travelinsu.clickproceedtravellers();
		travelinsu.clickTravellers();
		travelinsu.clickTraveller1();
		travelinsu.selectTraveller1Age();
		travelinsu.clickTraveller2();
		travelinsu.selectTraveller2Age();
		travelinsu.clickproceedmedical();
		travelinsu.clickyes();	
		travelinsu.selectTraveller1();
		travelinsu.selectTraveller2();
		travelinsu.selectfinalproceed();
	}
	@When("User navigate to car insurance page")
	public void user_navigate_to_car_insurance_page() throws IOException, InterruptedException {
		carinsu.NavigateBack();
	}
	@When("User enters car details")
	public void user_enters_car_details() throws InterruptedException {
		carinsu.clickMenu();
		carinsu.clickCarInsurance();
		carinsu.clickProceed();
	}
	@Then("User checks health insurance page")
	public void user_checks_health_insurance_page() throws InterruptedException {
		healthinsu.HomePage();
		healthinsu.insuranceproducts();
		getLogger().info("Ending Smoke Testing");
		
	}




}
