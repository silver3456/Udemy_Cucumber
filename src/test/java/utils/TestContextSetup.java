package utils;

import com.udemy.bdd.factory.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
    public String landingProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() {
        testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
