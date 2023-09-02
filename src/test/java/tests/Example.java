package tests;

import function.Login;
import org.testng.annotations.Test;
import util.TestBase;

import static common.RequestComponent.BLANK_USERNAME_ERROR_MSG;
import static common.RequestComponent.INVALID_CREDENTIALS_ERROR_MSG;

public class Example extends TestBase {

    @Test(priority = 1, alwaysRun = true,enabled = true)
    public void invalidCredentials() {
        Login.invalidUserLogin("testUser", "1234");
        softAssert.assertEquals(Login.displayedErrorMsg(), INVALID_CREDENTIALS_ERROR_MSG);
        softAssert.assertAll();
    }

    @Test(priority = 2, alwaysRun = true,enabled = true)
    public void blankUsername() {
        Login.blankUsername("", propertyConfig.password());
        softAssert.assertEquals(Login.displayedErrorMsg(), BLANK_USERNAME_ERROR_MSG);
        softAssert.assertAll();
    }

    @Test(priority = 3, alwaysRun = true,enabled = true)
    public void successfulLogin() {
        Login.successfulUserLogin(propertyConfig.username(), propertyConfig.password());
    }
}
