package ui;

import org.openqa.selenium.By;
import unitls.BaseTest;

public class LoginUI extends BaseTest {
    public static By usernameField = By.id("user-name");
    public static By passwordField = By.id("password");
    public static By loginButton = By.id("login-button");
    public static By errorMessage = By.cssSelector(".error-message-container");
}

