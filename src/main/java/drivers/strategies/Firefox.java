package drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// Only placeholder.  XXX - need be edited.

public class Firefox implements DriverStrategy{
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
