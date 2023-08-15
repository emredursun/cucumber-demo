package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:test-results/default-cucumber-reports.html",
                "json:test-results/json-reports/cucumber.json",
                "junit:test-results/xml-report/cucumber.xml",
                "rerun:test-results/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@ui",
        dryRun = false
)
public class Runner {
}
