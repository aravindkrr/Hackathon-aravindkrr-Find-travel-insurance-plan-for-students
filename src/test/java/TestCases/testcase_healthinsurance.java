package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.HealthInsurance;



public class testcase_healthinsurance extends base{
	HealthInsurance health;
		@Test(priority = 18,groups={"smoke","regression"})
		public void navigateHomePage() throws InterruptedException {
			health=new HealthInsurance(driver);
			health.HomePage();
			logger.info("Starting testcase_healthinsurance");
			
		}
		
		@Test(priority = 19,groups={"smoke","regression"})
		public void clickproduct() {
			health.insuranceproducts();
			}
		@Test(priority = 20,groups={"regression"})
		public void displayinsurancelist() throws IOException {
			logger.info("Getting the list of Insurance Product Plans ");
			health.healthInsuranceProducts();
			logger.info("Ending testcase_healthinsurance");
		}


}