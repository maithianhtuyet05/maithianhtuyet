package ui;

import org.openqa.selenium.By;
import unitls.BaseTest;

public class CartUI extends BaseTest {
    public static By cartButton = By.className("shopping_cart_link");
    public static By cartItems = By.className("cart_item");
    public static By checkoutButton = By.id("checkout");
}
