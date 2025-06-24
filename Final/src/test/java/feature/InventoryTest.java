package feature;

import action.Inventory;
import action.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import unitls.BaseTest;

public class InventoryTest extends BaseTest {

    @Test
    public void testAddItemToCart() {
        new Login(driver).login("standard_user", "secret_sauce");

        Inventory inventory = new Inventory(driver);
        inventory.addItemByIndex(0);

        Assert.assertEquals(inventory.getCartCount(), 1, "Sản phẩm không được thêm vào giỏ hàng.");
    }

    @Test
    public void testSortByNameAZ() {
        new Login (driver).login("standard_user", "secret_sauce");

        Inventory inventory = new Inventory (driver);
        inventory.sortBy("Name (A to Z)");


    }

    @Test
    public void testSortByPriceHighToLow() {
        new Login (driver).login("standard_user", "secret_sauce");

        Inventory inventory = new Inventory(driver);
        inventory.sortBy("Price (high to low)");

        // Có thể thêm verify giá nếu cần
    }
}
