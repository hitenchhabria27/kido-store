package validations.checkout;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;
import validations.checkout.constants.CheckoutConstants;

import java.time.Duration;
import java.util.HashMap;

public class Checkout implements CheckoutConstants {
    WebDriver driver;
    WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnAddAddressButton() throws InterruptedException {
        WebElement addAddressButton = driver.findElement(ADD_ADDRESS_BUTTON);
        DriverUtils.scrollToElement(addAddressButton, driver);
        addAddressButton.click();
    }

    public void enterAddress(String address) {
//        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_INPUT));
        addressInput.sendKeys(address);
    }

    public void enterPinCode(String pinCode) {
        driver.findElement(PINCODE_INPUT).sendKeys(pinCode);
    }

    public void enterState() {
        driver.findElement(STATE_DROPDOWN).click();
        driver.findElement(MAHARASHTRA_STATE).click();
    }

    public void enterCity(String city) {
        driver.findElement(CITY_INPUT).sendKeys(city);
    }

    public void enterAddressDetails(HashMap<String, Object> addressDetails) {
        String address =  (String) addressDetails.get("address");
        String city =  (String) addressDetails.get("city");
        String pincode = (String) addressDetails.get("pincode");

        enterAddress(address);
        enterCity(city);
        enterPinCode(pincode);
        enterState();
    }

    public void clickOnSaveButton() {
        driver.findElement(SAVE_ADDRESS_BUTTON).click();
    }

    public boolean isSuccessfullyAddedAddressMessageWasVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_ADDED_SUCCESSFULLY_MODAL)).isDisplayed();
    }
}
