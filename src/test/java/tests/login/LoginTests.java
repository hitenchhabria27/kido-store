package tests.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import validations.Login.Login;
import validations.loader.Loader;
import validations.navbar.NavBar;
import validations.navigation.Navigation;

public class LoginTests {
    Login login;
    Navigation navigation;
    Loader loader;
    NavBar navBar;

    public LoginTests(WebDriver driver) {
        login = new Login(driver);
        navigation = new Navigation(driver);
        loader = new Loader(driver);
        navBar = new NavBar(driver);
    }

    public void visitLoginPage() {
        navigation.visitLoginPage();
    }

    public void login(String username, String password) {
        loader.waitForLoaderToGetInvisible();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnLoginButton();
    }

    public void validateSuccessfulLogin() {
        Assert.assertTrue(navBar.isUserIconVisible(), "Failed to login");
    }

    public void isFailedToLoginMessageVisible() {
        Assert.assertTrue(login.isLoginPageVisible(), "Logged in with Wrong credentials or error message not visible");
    }

    public void loginWithUsernameOnly(String username) {
        loader.waitForLoaderToGetInvisible();
        login.enterUsername(username);
        login.clickOnLoginButton();
    }

    public void isPasswordFieldRequiredMessageVisible() {
        Assert.assertTrue(login.isPasswordFieldRequiredMessageVisible(), "Password required message not visible");
    }

    public void loginWithPasswordOnly(String password) {
        loader.waitForLoaderToGetInvisible();
        login.enterPassword(password);
        login.clickOnLoginButton();
    }

    public void isUsernameFieldRequiredMessageVisible() {
        Assert.assertTrue(login.isUsernameFieldRequiredMessageVisible(), "Username required message not visible");
    }
}
