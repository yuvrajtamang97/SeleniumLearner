package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@saucedemomultiplecases", features = {"src/test/resources/features"}, glue = {"stepdefinations"}, plugin = {"pretty", "html:target/cucumber-report.html"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests{

}
