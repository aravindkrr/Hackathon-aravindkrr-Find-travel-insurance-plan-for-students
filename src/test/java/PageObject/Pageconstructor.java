package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pageconstructor {
			WebDriver driver;
			public Pageconstructor(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
}