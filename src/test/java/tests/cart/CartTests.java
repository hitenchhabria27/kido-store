package tests.cart;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import validations.cart.Cart;
import validations.home.exclusiveProducts.ExclusiveProducts;
import validations.loader.Loader;
import validations.navbar.NavBar;
import validations.singleProduct.SingleProduct;

import java.util.HashMap;

public class CartTests {
    SingleProduct singleProduct;
    ExclusiveProducts exclusiveProducts;
    Loader loader;
    NavBar navBar;
    Cart cart;

    public CartTests(WebDriver driver) {
        singleProduct = new SingleProduct(driver);
        loader = new Loader(driver);
        navBar = new NavBar(driver);
        exclusiveProducts = new ExclusiveProducts(driver);
        cart = new Cart(driver);
    }

    public void openRandonProductFromStudyMaterialTab(){
        exclusiveProducts.openRandomProductFromStudyMaterialTab();
    }

    public void addProductToCart() {
        loader.waitForLoaderToGetInvisible();
        singleProduct.clickOnAddToCartButton();
    }

    public void validateAddedToCartMessage() {
        Assert.assertTrue(singleProduct.isSuccessfullyAddedToCartMessageVisible(), "Failed to add product to cart or message not visible");
    }

    public void openCart() {
        navBar.openCart();
    }

    public void validateAddedProductInCart() {
        HashMap<String, Object> addedProduct = singleProduct.getProductData();
        loader.waitForLoaderToGetInvisible();
        Assert.assertTrue(cart.isProductVisibileInCart((String) addedProduct.get("name")), "Product is not visible in cart");
    }

    public void openCheckoutPage() throws InterruptedException {
        cart.clickOnProceedToCheckoutButton();
    }
}
