package pageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.AccessDetailsPageUI;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdsPopup() {
        WebElement iFrame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
        driver.switchTo().frame(iFrame1);
        WebElement iFrame2 = driver.findElement(By.id("ad_iframe"));
        driver.switchTo().frame(iFrame2);
        waitForElementClickable(driver, LoginPageUI.CLOSE_ADS_BUTTON);
        clickOnElement(driver, LoginPageUI.CLOSE_ADS_BUTTON);
        driver.switchTo().defaultContent();
    }
    public void inputToEmailTextbox(String inputData) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, inputData);
    }

    public void clickOnSubmitButton() {
        waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
        clickOnElement(driver, RegisterPageUI.SUBMIT_BUTTON);
    }

    public String getUsernameInformation() {
        waitForElementVisible(driver, AccessDetailsPageUI.USER_ID);
        return getElementText(driver, AccessDetailsPageUI.USER_ID);
    }

    public String getPasswordInformation() {
        waitForElementVisible(driver, AccessDetailsPageUI.PASSWORD);
        return getElementText(driver, AccessDetailsPageUI.PASSWORD);
    }
}
