package ui;

import org.openqa.selenium.By;
import unitls.BaseTest;

public class CheckoutUI extends BaseTest {
    public static By firstNameField = By.id("first-name");
    public static By lastNameField = By.id("last-name");
    public static By postalCodeField = By.id("postal-code");
    public static By continueButton = By.id("continue");
    public static By finishButton = By.id("finish");
    public static By summaryTotal = By.className("summary_total_label");
}
