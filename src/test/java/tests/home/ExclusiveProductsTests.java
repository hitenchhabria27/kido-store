package tests.home;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import validations.home.exclusiveProducts.ExclusiveProducts;
import validations.loader.Loader;

public class ExclusiveProductsTests {
    ExclusiveProducts exclusiveProducts;
    Loader loader;

    public ExclusiveProductsTests(WebDriver driver) {
        exclusiveProducts = new ExclusiveProducts(driver);
        loader = new Loader(driver);
    }

    public void openStudyMaterialTab() throws InterruptedException {
        loader.waitForLoaderToGetInvisible();
        exclusiveProducts.clickOnStudyMatrials();
    }

    public void validateNumberOfProductsFeaturedOnStudyMaterialTab(){
        Assert.assertEquals(exclusiveProducts.getNumberOfProductsFeaturedOnStudyMaterialTab(),8, "Number of products does not match");
    }
}
