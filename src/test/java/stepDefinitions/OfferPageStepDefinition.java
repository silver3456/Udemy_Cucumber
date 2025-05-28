package stepDefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.bdd.factory.PageObjectManager;
import com.udemy.bdd.pages.LandingPage;
import com.udemy.bdd.pages.OffersPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class OfferPageStepDefinition {
    public String offerProductName;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;


    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        offerProductName = offersPage.getProductName();
        System.out.println(offerProductName + " is extracted from Offers page");
    }

    public void switchToOffersPage() {
        //if switched to offer page-> skip below part
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
        Assert.assertEquals(offerProductName, testContextSetup.landingProductName);
    }
}
