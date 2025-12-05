package tests.cart.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import validations.cart.Cart;
import validations.checkout.Checkout;

import java.util.HashMap;

public class CheckoutTests {
    Cart cart;
    Checkout checkout;
    HashMap<String, Object> addressDetails;
    public CheckoutTests(WebDriver driver) {
        cart = new Cart(driver);
        checkout = new Checkout(driver);
        addressDetails = new HashMap<>();
        addressDetails.put("city", "London");
        addressDetails.put("state", "New York");
        addressDetails.put("pincode", "421004");
        addressDetails.put("address", "Street-11");
    }

    public void clickOnAddAddressButton() throws InterruptedException {
        checkout.clickOnAddAddressButton();
    }

    public void addNewAddress() {
        checkout.enterAddressDetails(addressDetails);
        checkout.clickOnSaveButton();
    }

    public void validateSuccessfulAddedAddress() {
        Assert.assertTrue(checkout.isSuccessfullyAddedAddressMessageWasVisible(), "Failed to add Address or Successfully added address Message not visible!");
    }
}
