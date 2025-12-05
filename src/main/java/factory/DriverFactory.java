package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public void setDriver(String browser) throws URISyntaxException, MalformedURLException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_leak_detection", false);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        if(browser.equalsIgnoreCase("chrome")){
            tl.set(new ChromeDriver(chromeOptions));
        } else if(browser.equalsIgnoreCase("edge")) {
            tl.set(new EdgeDriver());
        }
//        URL url = new URI("http://192.168.0.110:4444").toURL();
//        DesiredCapabilities dersiredCapabilities = new DesiredCapabilities();
//        dersiredCapabilities.setCapability("browserName", "chrome");
//        dersiredCapabilities.setCapability("platformName", "mac");
//        tl.set(new RemoteWebDriver(url, dersiredCapabilities));
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return tl.get();
    }
}
