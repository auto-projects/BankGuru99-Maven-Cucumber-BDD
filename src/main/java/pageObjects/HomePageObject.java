package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessfulMessageDisplayed() {
        waitForElementVisible(driver, HomePageUI.SUCCESSFUL_MESSAGE);
        return isElementDisplayed(driver, HomePageUI.SUCCESSFUL_MESSAGE);
    }
    public String getSuccessfulMessage() {
        waitForElementVisible(driver, HomePageUI.SUCCESSFUL_MESSAGE);
        return getElementText(driver, HomePageUI.SUCCESSFUL_MESSAGE);
    }

    public boolean isUserIDDisplayed() {
        waitForElementVisible(driver, HomePageUI.USER_ID_MESSAGE);
        return isElementDisplayed(driver, HomePageUI.USER_ID_MESSAGE);
    }
    public String getMangerUserID() {
        waitForElementVisible(driver, HomePageUI.USER_ID_MESSAGE);
        return getElementText(driver, HomePageUI.USER_ID_MESSAGE);
    }

    public void inputToAddressTextbox(WebDriver driver, String address) {
        waitForElementVisible(driver, HomePageUI.ADDRESS_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.ADDRESS_TEXTBOX, address);
    }

    public boolean theSuccessfulMessageIsDisplayed(WebDriver driver, String messageValue) {
        waitForElementVisible(driver, HomePageUI.SUCCESSFUL_MESSAGE_OF_NEW_CUSTOMER, messageValue);
        return isElementDisplayed(driver, HomePageUI.SUCCESSFUL_MESSAGE_OF_NEW_CUSTOMER, messageValue);
    }
}
