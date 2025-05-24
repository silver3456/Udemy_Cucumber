package stepDefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.supplier.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class LandingPageStepDefinition {
    public String landingProductName;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        testContextSetup.driver = DriverFactory.getDriver("chrome");
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        testContextSetup.driver.findElement(By.cssSelector("input[type = 'search']")).sendKeys(shortName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        testContextSetup.landingProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingProductName + " is extracted from Home page");

    }
}
