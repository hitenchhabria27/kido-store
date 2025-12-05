package validations.checkout.constants;

import org.openqa.selenium.By;

public interface CheckoutConstants {
    By ADD_ADDRESS_BUTTON = By.id("add_address_btn");
    By ADDRESS_INPUT = By.id("addr-line-1");
    By PINCODE_INPUT = By.id("zipcode");
    By CITY_INPUT = By.id("city");
    By STATE_DROPDOWN = By.xpath("//select[@id='state']");
    By MAHARASHTRA_STATE = By.xpath("//select[@id='state']/option[@value='1']");
    By SAVE_ADDRESS_BUTTON = By.xpath("//button[@id='home-form-btn']");
    By ADDRESS_ADDED_SUCCESSFULLY_MODAL = By.xpath("//div[@class='notyf-announcer']");
}
