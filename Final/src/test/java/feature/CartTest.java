package feature;

import action.Cart;
import action.Checkout;
import action.Inventory;
import action.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.CartUI;
import unitls.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void testCartDisplay() {
        // Đăng nhập
        new Login(driver).login("standard_user", "secret_sauce");

        // Thêm 1 sản phẩm vào giỏ
        Inventory inventory = new Inventory(driver);
        inventory.addItemByIndex(0);

        // Mở trang giỏ hàng
        Cart cart = new Cart (driver);
        cart.openCartPage();

        // Kiểm tra
        Assert.assertTrue(cart.getCartItemCount() > 0, "Giỏ hàng không có sản phẩm nào.");
        Assert.assertTrue(cart.isCheckoutButtonDisplayed(), "Nút Checkout không hiển thị.");
    }
    @Test
    public void testCartEmptyState() {
        new Login(driver).login("standard_user", "secret_sauce");

        Cart cart = new Cart(driver);
        cart.openCartPage();

        Assert.assertEquals(cart.getCartItemCount(), 0, "Giỏ hàng không rỗng khi chưa thêm sản phẩm.");
        Assert.assertFalse(cart.isCheckoutButtonDisplayed(), "Nút checkout vẫn hiển thị dù giỏ hàng rỗng.");
    }
    @Test
    public void testCheckoutWithoutFirstName() {
        new Login(driver).login("standard_user", "secret_sauce");
        new Inventory(driver).addItemByIndex(0);
        new Cart(driver).openCartPage();
        driver.findElement(CartUI.checkoutButton).click();

        Checkout checkout = new Checkout(driver);
        checkout.fillCustomerInformation("", "Doe", "12345");
        checkout.continueToOverview();

        Assert.assertFalse(checkout.isOverviewDisplayed(), "Cho phép tiếp tục khi thiếu First Name.");
    }

    @Test
    public void testCheckoutWithoutLastName() {
        new Login(driver).login("standard_user", "secret_sauce");
        new Inventory(driver).addItemByIndex(0);
        new Cart(driver).openCartPage();
        driver.findElement(CartUI.checkoutButton).click();

        Checkout checkout = new Checkout(driver);
        checkout.fillCustomerInformation("John", "", "12345");
        checkout.continueToOverview();

        Assert.assertFalse(checkout.isOverviewDisplayed(), "Cho phép tiếp tục khi thiếu Last Name.");
    }

    @Test
    public void testCheckoutWithoutPostalCode() {
        new Login(driver).login("standard_user", "secret_sauce");
        new Inventory(driver).addItemByIndex(0);
        new Cart(driver).openCartPage();
        driver.findElement(CartUI.checkoutButton).click();

        Checkout checkout = new Checkout(driver);
        checkout.fillCustomerInformation("John", "Doe", "");
        checkout.continueToOverview();

        Assert.assertFalse(checkout.isOverviewDisplayed(), "Cho phép tiếp tục khi thiếu Postal Code.");
    }
}
