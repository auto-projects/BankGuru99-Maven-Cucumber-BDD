package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/bankguru99/features",
		glue = "bankguru99.stepDefinitions",
		//dryRun = true,
		strict = true,
		monochrome = true,
		plugin = { "pretty", "html: target/site/cucumber-report-default", "json: target/site/cucumber.json" },

		snippets = SnippetType.CAMELCASE,
		tags = { "@register_new_account, @login_new_account, @new_customer" })

public class Guru99TestRunner {

}
