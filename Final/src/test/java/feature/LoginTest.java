package feature;

import action.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import unitls.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithValidCredentials() {
        Login login = new Login(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(login.isLoginSuccessful(), "Đăng nhập hợp lệ nhưng không chuyển sang trang Inventory.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        Login login = new Login(driver);
        login.login("invalid_user", "invalid_pass");
        Assert.assertTrue(login.isLoginErrorDisplayed(), "Không hiển thị lỗi khi đăng nhập sai.");
    }
    @Test
    public void testLoginWithEmptyUsername() {
        Login login = new Login(driver);
        login.login("", "secret_sauce");
        Assert.assertTrue(login.isLoginErrorDisplayed(), "Không hiển thị lỗi khi để trống username.");
    }

    @Test
    public void testLoginWithEmptyPassword() {
        Login login = new Login(driver);
        login.login("standard_user", "");
        Assert.assertTrue(login.isLoginErrorDisplayed(), "Không hiển thị lỗi khi để trống password.");
    }

    @Test
    public void testLoginWithEmptyUsernameAndPassword() {
        Login login = new Login(driver);
        login.login("", "");
        Assert.assertTrue(login.isLoginErrorDisplayed(), "Không hiển thị lỗi khi bỏ trống cả username và password.");
    }

}
