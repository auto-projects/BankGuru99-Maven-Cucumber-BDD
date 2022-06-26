package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/guru99bank/features",
		glue = "guru99bank.stepDefinitions",
		//dryRun = true,
		strict = true,
		monochrome = true,
		plugin = { "pretty", "html: target/site/cucumber-report-default", "json: target/site/cucumber.json" },
		snippets = SnippetType.CAMELCASE,
		tags = { "@bank_guru_99" })

public class guru99TestRunner {

}
