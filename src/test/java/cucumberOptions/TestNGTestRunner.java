package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/* Use flag dryRun = true when I want to run the script to compile file and grab step
 */

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
