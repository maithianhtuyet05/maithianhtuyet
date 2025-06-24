package action;

import org.openqa.selenium.WebDriver;
import ui.CheckoutUI;

public class Checkout {
    private WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(CheckoutUI.firstNameField).sendKeys(firstName);
        driver.findElement(CheckoutUI.lastNameField).sendKeys(lastName);
        driver.findElement(CheckoutUI.postalCodeField).sendKeys(postalCode);
    }

    public void continueToOverview() {
        driver.findElement(CheckoutUI.continueButton).click();
    }

    public boolean isOverviewDisplayed() {
        return driver.findElement(CheckoutUI.summaryTotal).isDisplayed();
    }

    public void finishCheckout() {
        driver.findElement(CheckoutUI.finishButton).click();
    }

    public boolean isCheckoutComplete() {
        return driver.getCurrentUrl().contains("checkout-complete.html");
    }
}
