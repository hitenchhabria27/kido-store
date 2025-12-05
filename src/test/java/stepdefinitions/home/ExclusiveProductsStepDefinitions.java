package stepdefinitions.home;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import tests.home.ExclusiveProductsTests;

public class ExclusiveProductsStepDefinitions {
    WebDriver driver;

    ExclusiveProductsTests exclusiveProductsTests;

    public ExclusiveProductsStepDefinitions(){
        driver = DriverFactory.getDriver();
        exclusiveProductsTests = new ExclusiveProductsTests(driver);
    }

    @Given("I clicked on study material tab")
    public void iClickedOnStudyMaterialTab() throws InterruptedException {
        exclusiveProductsTests.openStudyMaterialTab();
    }

    @Then("Only required number of products featured on study material tab")
    public void requiredNumberOfProductsFeaturedOnStudyMaterialTab(){
        exclusiveProductsTests.validateNumberOfProductsFeaturedOnStudyMaterialTab();
    }
}
