package pages;

import drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }




    //Change Css selectors on ID selectors
    @FindBy(id = "billing_first_name")
    private WebElement firstName;
    @FindBy(css = "#billing_last_name")
    private WebElement lastName;
    @FindBy(css = "#billing_address_1")
    private WebElement address;
    @FindBy(css = "#billing_postcode")
    private WebElement zipcode;
    @FindBy(css = "#billing_city")
    private WebElement townName;
    @FindBy(css = "#billing_email")
    private WebElement email;
    @FindBy(css = "#place_order")
    private  WebElement placeOrder;
    @FindBy(id = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private WebElement totalAmont;
    @FindBy(css = "#post-207 > content > div > div > div > p")
    private WebElement orderStatus;

    public void provideBillingDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(address));
        address.sendKeys("");
    }
    public String getTotalAmont() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(totalAmont));
        return totalAmont.getText();
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        placeOrder.click();
    }

    public String getOrderStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(orderStatus));
        return orderStatus.getText();
    }



}

















