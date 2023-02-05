

/*Test Runner File for Cucumber */
/*---------------------------------------------------------------------------------------------*/
package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Running the scenario marked as with the given tags or all the features
@CucumberOptions(tags ="@demotest",
        features = {"src/test/java/Features"},
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:target/HtmlReports"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {



}