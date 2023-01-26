import drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) throws Exception {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get(Constants.URL1);

        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        HomePage homePage = new HomePage();
        ShopPage shopPage =new ShopPage();
        SingInPage singInPage = new SingInPage();

        homePage.clickSingIn();
        singInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));

        if (homePage.getUsername().equals("Hello, Client"))
            System.out.println("Test Passed");
        else
            System.out.println("test Failed");

        homePage.clickShopButton();

        shopPage.addElementToCart();
        shopPage.proceedToCheckout();
        cartPage.proceedToCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.placeOrder();

        if(checkoutPage.getOrderStatus().equals("Thank you. Your order has been received.")) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
            throw new Exception();
        }


        DriverSingleton.closeObjectInstance();
    }
}
















