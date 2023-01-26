import drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;
import utils.Constants;
import utils.FrameworkProperties;

public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SingInPage singInPage;
    static CheckoutPage checkoutPage;

    @Test
    public void testingAuthentication(){
        driver.get(Constants.URL2);
        homePage.clickSingIn();
    }


}