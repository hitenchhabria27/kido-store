package validations.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;
import validations.cart.constants.CartConstants;

public class Cart implements CartConstants {
    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductVisibileInCart(String productName) {
        String formattedXpath = PRODUCT_NAME.replace("productName", productName);
        return driver.findElement(By.xpath(formattedXpath)).isDisplayed();
    }

    public void clickOnProceedToCheckoutButton() throws InterruptedException {
        WebElement checkoutButton = driver.findElement(CHECKOUT_BUTTON);
        DriverUtils.scrollToElement(checkoutButton, driver);
        checkoutButton.click();
    }
}
