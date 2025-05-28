package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> handles = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }
}
