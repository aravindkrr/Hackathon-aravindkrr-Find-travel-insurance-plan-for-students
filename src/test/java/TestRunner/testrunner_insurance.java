package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
		features= {"C:\\Users\\2304100\\eclipse-workspace\\Hackathon\\FeatureFiles\\Insurance.feature"},
			glue="StepDefiniton" ,
			plugin= {"html:Reports/CucumberReport.html","rerun:target/rerun.txt",
					  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			dryRun=!true,
            monochrome=true,
            publish=true,
            //tags="@SmokeTesting"
            tags="@RegressionTesting"
            
            )
public class testrunner_insurance {

}
