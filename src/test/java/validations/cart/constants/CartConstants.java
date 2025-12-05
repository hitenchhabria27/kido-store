package validations.cart.constants;

import org.openqa.selenium.By;

public interface CartConstants {
    String PRODUCT_NAME = "//tbody[@id='cart-table-body']//td[2][normalize-space()='productName']";
    By CHECKOUT_BUTTON = By.xpath("//a[@href='https://kidostore.in/checkout'][@class='btn btn-fill-out']");
}
