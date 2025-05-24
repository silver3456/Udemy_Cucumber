import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class GoogleTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void test() {
        this.driver.get("https://www.google.com");
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
