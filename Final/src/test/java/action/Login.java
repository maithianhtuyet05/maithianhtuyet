package action;

import org.openqa.selenium.WebDriver;
import ui.LoginUI;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(LoginUI.usernameField).sendKeys(username);
        driver.findElement(LoginUI.passwordField).sendKeys(password);
        driver.findElement(LoginUI.loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(LoginUI.errorMessage).isDisplayed();
    }
}
