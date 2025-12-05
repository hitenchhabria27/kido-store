package validations.Login.constants;

import org.openqa.selenium.By;

public interface LoginConstants {
    By EMAIL_INPUT = By.name("email");
    By PASSWORD_INPUT = By.name("password");
    By LOGIN_BUTTON = By.id("btn-submit");
    By LOGIN_TITLE = By.xpath("//h3[normalize-space()='Login']");
    By PASSWORD_REQUIRED_MESSAGE = By.xpath("//input[@id='password']/..//div[@class='invalid-feedback']");
    By USERNAME_REQUIRED_MESSAGE = By.xpath("//input[@id='email']/..//div[@class='invalid-feedback']");
}
