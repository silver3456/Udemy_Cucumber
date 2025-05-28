package utils;


import com.udemy.bdd.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String url = properties.getProperty("qaUrl");
        if (driver == null) {
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = DriverFactory.getDriver("chrome");
            }
            driver.get(url);
        }
        return driver;
    }
}
