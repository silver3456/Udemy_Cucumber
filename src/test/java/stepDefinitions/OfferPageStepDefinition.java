package stepDefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OfferPageStepDefinition {
    public String offerProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @Then("user searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();

        Set<String> handles = testContextSetup.driver.getWindowHandles();
        String mainWindow = testContextSetup.driver.getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                testContextSetup.driver.switchTo().window(handle);
            }
        }

        testContextSetup.driver.findElement(By.cssSelector("input#search-field")).sendKeys(shortName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        offerProductName = testContextSetup.driver.findElement(By.cssSelector("table.table.table-bordered tr>td:nth-child(1)")).getText().trim();
        System.out.println(offerProductName + " is extracted from Offers page");
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
        Assert.assertEquals(testContextSetup.landingProductName, offerProductName);
    }
}
