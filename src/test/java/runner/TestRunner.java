package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "step_definitions",dryRun = false,tags = "@listofListsDataTable",plugin = {"html:/target/reports/cucumber-reports.html"})
public class TestRunner {


}
