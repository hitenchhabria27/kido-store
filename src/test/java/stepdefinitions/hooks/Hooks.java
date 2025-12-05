package stepdefinitions.hooks;

import factory.DriverFactory;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() throws MalformedURLException, URISyntaxException {
        driverFactory.setDriver("chrome");
    }
}
