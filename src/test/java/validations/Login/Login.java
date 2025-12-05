package validations.Login;

import org.openqa.selenium.WebDriver;
import validations.Login.constants.LoginConstants;

public class Login implements LoginConstants {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(EMAIL_INPUT).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public boolean isLoginPageVisible() { return driver.findElement(LOGIN_TITLE).isDisplayed(); }

    public boolean isPasswordFieldRequiredMessageVisible() {
        return driver.findElement(PASSWORD_REQUIRED_MESSAGE).isDisplayed();
    }

    public boolean isUsernameFieldRequiredMessageVisible() {
        return driver.findElement(USERNAME_REQUIRED_MESSAGE).isDisplayed();
    }
}
