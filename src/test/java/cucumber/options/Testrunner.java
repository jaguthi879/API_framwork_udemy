package cucumber.options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
                 glue={"stepdefinitionfiles"},
                plugin ={"json:target/jsonReports/cuc.json","html:target/jsonReports/cuc.html"})
public class Testrunner extends AbstractTestNGCucumberTests{
	
	//tags= "@DeletePlace"

}
	
