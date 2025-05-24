package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/* Use flag dryRun = true when I want to run the script to compile file and grab step
 */

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
