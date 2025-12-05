package stepdefinitions.cart.checkout;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import tests.cart.CartTests;
import tests.cart.checkout.CheckoutTests;
import validations.loader.Loader;

public class CheckoutStepDefinition {
    WebDriver driver;
    CartTests cartTests;
    CheckoutTests checkoutTests;
    Loader loader;

    public CheckoutStepDefinition() {
        driver = DriverFactory.getDriver();
        cartTests = new CartTests(driver);
        loader = new Loader(driver);
        checkoutTests = new CheckoutTests(driver);
    }

    @Given("I clicked on Proceed to Checkout button")
    public void iClickedOnProceedToCheckoutButton() throws  InterruptedException {
        cartTests.openCheckoutPage();
    }

    @Then("I clicked on Add Address Button")
    public void iClickedOnAddAddressButton() throws InterruptedException{
        loader.waitForLoaderToGetInvisible();
        checkoutTests.clickOnAddAddressButton();
    }

    @And("I entered Address")
    public void iEnteredAddress() {
        checkoutTests.addNewAddress();
    }

    @Then("Successfully added Address message was visible")
    public void successfullyAddedAddressMessageWasVisible() {
        checkoutTests.validateSuccessfulAddedAddress();
    }
}
