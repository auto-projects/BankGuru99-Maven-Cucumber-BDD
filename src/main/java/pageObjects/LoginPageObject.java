package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHereButton() {
        waitForElementClickable(driver, LoginPageUI.HERE_BUTTON);
        clickOnElement(driver, LoginPageUI.HERE_BUTTON);
    }



    public void inputToUserIDTextbox(String userID) {
        waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, password);
    }

    public void clickOnLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickOnElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

}
