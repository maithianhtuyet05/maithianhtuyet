package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.InventoryUI;

import java.util.List;

public class Inventory {
    private WebDriver driver;

    public Inventory(WebDriver driver) {
        this.driver = driver;
    }

    public void sortBy(String value) {
        Select sort = new Select(driver.findElement(InventoryUI.sortDropdown));
        sort.selectByVisibleText(value);
    }

    public void addItemByIndex(int index) {
        List<WebElement> buttons = driver.findElements(InventoryUI.addToCartButtons);
        if (index < buttons.size()) {
            buttons.get(index).click();
        }
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(driver.findElement(InventoryUI.cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }
}
