package stepdefinitions.login;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import tests.login.LoginTests;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginTests loginTests;

    public LoginStepDefinitions() {
        driver = DriverFactory.getDriver();
        loginTests = new LoginTests(driver);
    }

    @Given("I visited login page")
    public void iVisitedLoginPage() {
        loginTests.visitLoginPage();
    }

    @Given("I entered username {string} and password {string}")
    public void iEnteredUsernameAndPassword(String username, String password) {
        loginTests.login(username, password);
    }

    @Then("I logged in successfully")
    public void isLoggedInSuccessfully() {
        loginTests.validateSuccessfulLogin();
    }

    @Then("I failed to login")
    public void iFailedToLogin() {
        loginTests.isFailedToLoginMessageVisible();
    }

    @Given("I entered username {string}")
    public void iEnteredUsernameOnly(String username) {
        loginTests.loginWithUsernameOnly(username);
    }

    @Then("I failed to login using username only")
    public void iFailedToLoginUsingUsernameOnly() {
        loginTests.isPasswordFieldRequiredMessageVisible();
    }

    @Given("I entered password {string}")
    public void iEnteredPasswordOnly(String password) {
        loginTests.loginWithPasswordOnly(password);
    }

    @Then("I failed to login using passwoed only")
    public void iFailedToLoginUsingPasswoedOnly() {
        loginTests.isUsernameFieldRequiredMessageVisible();
    }
}
