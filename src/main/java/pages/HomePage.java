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

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-440 > a")
    private WebElement singInButton;

    @FindBy(id="menu-item-430")
    private WebElement shopButton;

    @FindBy(css="#menu-item-443 > a")
    private WebElement username;

    public void clickSingIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(singInButton));
        singInButton.click();
    }

    public void clickShopButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(shopButton));
        shopButton.click();

    }
     public String getUsername() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
         wait.until(ExpectedConditions.elementToBeClickable(username));
        return username.getText();
    }
}
