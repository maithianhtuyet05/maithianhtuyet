package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.CartUI;

import java.util.List;

public class Cart {
    private WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void openCartPage() {
        driver.findElement(CartUI.cartButton).click();
    }

    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(CartUI.cartItems);
        return items.size();
    }

    public boolean isCheckoutButtonDisplayed() {
        return driver.findElement(CartUI.checkoutButton).isDisplayed();
    }
}
