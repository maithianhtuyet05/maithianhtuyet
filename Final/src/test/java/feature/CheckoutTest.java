package feature;

import action.Cart;
import action.Checkout;
import action.Inventory;
import action.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.CartUI;
import unitls.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        // Bước 1: Đăng nhập
        new Login(driver).login("standard_user", "secret_sauce");

        // Bước 2: Thêm 1 sản phẩm vào giỏ
        Inventory inventory = new Inventory(driver);
        inventory.addItemByIndex(0);

        // Bước 3: Mở trang giỏ hàng
        Cart cart = new Cart(driver);
        cart.openCartPage();

        // Bước 4: Nhấn Checkout
        driver.findElement(CartUI.checkoutButton).click();

        // Bước 5: Nhập thông tin
        Checkout checkout = new Checkout(driver);
        checkout.fillCustomerInformation("John", "Doe", "12345");
        checkout.continueToOverview();

        // Bước 6: Kiểm tra tổng quan đơn hàng
        Assert.assertTrue(checkout.isOverviewDisplayed(), "Không hiển thị thông tin tổng quan đơn hàng.");

        // Bước 7: Hoàn tất đơn hàng
        checkout.finishCheckout();
        Assert.assertTrue(checkout.isCheckoutComplete(), "Thanh toán không thành công.");
    }
}
