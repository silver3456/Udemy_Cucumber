package com.udemy.bdd.factory;

import com.udemy.bdd.pages.LandingPage;
import com.udemy.bdd.pages.OffersPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }

    public OffersPage getOffersPage() {
        return new OffersPage(driver);
    }
}
