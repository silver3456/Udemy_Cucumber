package com.udemy.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type = 'search']")
    public WebElement search;

    @FindBy(css = "h4.product-name")
    public WebElement productName;

    @FindBy(linkText = "Top Deals")
    public WebElement topDeals;

    public void searchItem(String shortName) {
        this.search.sendKeys(shortName);
    }

    public String getSearchText() {
        return this.search.getText();
    }

    public String getProductName() {
        return this.productName.getText();
    }

    public void selectTopDealsPage() {
        this.topDeals.click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

}
