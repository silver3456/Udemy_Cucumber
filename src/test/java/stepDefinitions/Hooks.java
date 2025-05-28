package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

import java.io.IOException;

/**
 * Hooks is used for pre- and post- conditions
 */
public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
       this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }
}
