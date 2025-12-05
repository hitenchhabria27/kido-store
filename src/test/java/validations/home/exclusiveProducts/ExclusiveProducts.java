package validations.home.exclusiveProducts;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtils;
import validations.home.exclusiveProducts.constants.ExclusiveProductsConstants;

import java.util.List;

public class ExclusiveProducts implements ExclusiveProductsConstants {
    WebDriver driver;
    Actions actions;
    Faker faker;

    public ExclusiveProducts(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.faker = new Faker();
    }

    public void clickOnStudyMatrials() throws InterruptedException{
        WebElement studyMaterialTab = driver.findElement(STUDY_MATERIAL_TAG);
        DriverUtils.scrollToElement(studyMaterialTab, driver);
        studyMaterialTab.click();
    }

    public int getNumberOfProductsFeaturedOnStudyMaterialTab() {
        return driver.findElements(STUDY_MATERIAL_CARDS).size();
    }

    public void openRandomProductFromStudyMaterialTab() {
        List<WebElement> products = driver.findElements(PRODUCT_VIEW_DETIALS_BUTTON);
        WebElement randomProduct = products.get(faker.random().nextInt(0,products.size()-1));
        actions.moveToElement(randomProduct);
        actions.perform();
        randomProduct.click();
    }
}
