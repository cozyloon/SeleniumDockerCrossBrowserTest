package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.DriverSetup.driver;

public class LoginPage {
    private By txtUsername = By.id("user-name");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("login-button");
    private By lblEmptyUsername = By.xpath("h3[data-test='error']");
    private By btnCloseErrorMsg = By.xpath("//button[@class='error-button']");


    public void setUsername(String username) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(txtUsername));
        element.clear();
        element.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(txtPassword));
        element.clear();
        element.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(btnLogin));
        element.submit();
    }

    public void clickCloseErrorMsgBtn() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(btnCloseErrorMsg));
        element.click();
    }

    public String errorMsgIsDisplayed() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(lblEmptyUsername));
        return element.getText();
    }
}
