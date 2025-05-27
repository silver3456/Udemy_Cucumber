package stepDefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.bdd.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class LandingPageStepDefinition {
    public String landingProductName;
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
    }


    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        landingPage.searchItem(shortName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        testContextSetup.landingProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(landingProductName + " is extracted from Home page");

    }
}
