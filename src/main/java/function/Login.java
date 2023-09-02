package function;

import pages.LoginPage;

public class Login {
    static LoginPage loginPage = new LoginPage();

    public static void invalidUserLogin(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
    }

    public static void blankUsername(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
    }

    public static void successfulUserLogin(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
    }

    public static String displayedErrorMsg() {
        String errorMsg = loginPage.errorMsgIsDisplayed();
        loginPage.clickCloseErrorMsgBtn();
        return errorMsg;
    }

}
