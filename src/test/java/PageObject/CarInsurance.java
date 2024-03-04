package PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Excel;

public class CarInsurance extends Pageconstructor {
	JavascriptExecutor js;
	public CarInsurance(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	@FindBy(xpath="//i[@class='arrow']") 
	WebElement downarrow;
	@FindBy(xpath="//a[text()='Car Insurance']") 
	WebElement carInsurance;
	@FindBy(xpath="//span[text()='car? Click here']") 
	WebElement proceed;
	@FindBy(xpath="//*[@id='pre-quote']/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]") 
	WebElement city;
	@FindBy(xpath="//label[@data-id='481']") 
	WebElement rto;
	@FindBy(xpath="//label[@data-id='33']") 
	WebElement brand;
	@FindBy(xpath="//label[@data-id='222']") 
	WebElement model;
	@FindBy(xpath="//span[text()='Petrol']") 
	WebElement fuel;
	@FindBy(xpath="//span[text()='Delta AMT'][@class='text']") 
	WebElement varient;
	@FindBy(xpath="//input[@id ='txtName']") 
	WebElement Fullname;
	@FindBy(xpath="//input[@id ='txtEmail']") 
	WebElement errorEmail;
	@FindBy(xpath="//span[@class='icon']")
	WebElement clickenter;
	@FindBy(xpath="//div[text()='Please enter valid email address']") 
	WebElement errormessage;
	
	
	public void NavigateBack() throws InterruptedException{
		driver.navigate().to("https://www.policybazaar.com/");
		Thread.sleep(1000);
		}
	public void clickMenu() {
		
		js.executeScript("arguments[0].click()",downarrow);
		}
	public void clickCarInsurance() throws InterruptedException
	{
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", carInsurance);
	}
	public void clickProceed() throws InterruptedException
	{
		proceed.click();
		Thread.sleep(2000);
	}
	public void clickCityName() throws InterruptedException
	{
		
		js.executeScript("arguments[0].click()", city);
		Thread.sleep(2000);
	}
	public void clickRTO() throws InterruptedException
	{
		rto.click();
		 Thread.sleep(2000);
	}
	public void clickCarBrand() throws InterruptedException
	{
		brand.click();
		 Thread.sleep(2000);
	}
	public void clickCarModel() throws InterruptedException
	{
		model.click();
		 Thread.sleep(2000);
	}
	public void clickFuelType() throws InterruptedException
	{
		fuel.click();
		 Thread.sleep(2000);
	}
	public void clickVarient() throws InterruptedException
	{
		varient.click();
		 Thread.sleep(2000);
	}
	public void EnterAnyName() throws InterruptedException, IOException
	{
		//Fullname.sendKeys("ravi");
		Fullname.sendKeys(Excel.getcelldata("Sheet1", 1, 2));
		Thread.sleep(2000);
	}
	public void EnterIncorrectEmail() throws InterruptedException, IOException
	{
		//errorEmail.sendKeys("xyz#da.com");
		errorEmail.sendKeys(Excel.getcelldata("Sheet1", 1, 3));
		 Thread.sleep(2000);
	}
	public void clickEnterButton() throws InterruptedException {
		clickenter.click();
		Thread.sleep(2000);
	}
	public void PrintErrorMessage() throws IOException, InterruptedException {
		System.out.println(errormessage.getText());
		 Thread.sleep(2000);
		 Excel.setcelldata("Sheet1",errormessage.getText() , 2, 0);
		
	}

}
