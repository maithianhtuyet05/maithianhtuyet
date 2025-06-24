package ui;

import org.openqa.selenium.By;
import unitls.BaseTest;

public class InventoryUI extends BaseTest{
public static By inventoryItems = By.className("inventory_item");
public static By addToCartButtons = By.cssSelector(".btn_inventory");
public static By cartBadge = By.className("shopping_cart_badge");
public static By sortDropdown = By.className("product_sort_container");
public static By itemName = By.className("inventory_item_name");
public static By itemPrice = By.className("inventory_item_price");
}
