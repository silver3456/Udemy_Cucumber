package com.udemy.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type = 'search']")
    private WebElement search;

    @FindBy(css = "table.table.table-bordered tr>td:nth-child(1)")
    public WebElement productName;

    public void searchItem(String shortName) {
        this.search.sendKeys(shortName);
    }

    public String getProductName() {
        return this.productName.getText();
    }
}
