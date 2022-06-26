package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CommonPageUI;

public class CommonPageObject extends BasePage {
    WebDriver driver;

    public CommonPageObject(WebDriver driver) {
        this.driver = driver;
    }

    // PAGE / LINK / SUB MENU
    public void openDynamicPageByText(WebDriver driver, String pageName) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_PAGE_BY_TEXT, pageName);
        clickOnElement(driver, CommonPageUI.DYNAMIC_PAGE_BY_TEXT, pageName);
    }

    // TEXTBOX
    public void inputIntoDynamicTextboxByText(WebDriver driver, String textboxByText, String inputData) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_TEXT, textboxByText);
        if (textboxByText.equals("dob")) {
            removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_TEXT, "type", textboxByText);
            sleepInSecond(1);
        }
        sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_TEXT, inputData, textboxByText);
    }

    // TEXTAREA
    public void inputIntoDynamicTextarea(WebDriver driver, String textareaByText, String inputData) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, textareaByText);
        sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, inputData, textareaByText);
    }

    // BUTTON
    public void clickOnDynamicButtonByValue(WebDriver driver, String buttonByValue) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonByValue);
        clickOnElement(driver, CommonPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonByValue);
    }

    // RADIO BUTTON
    public void selectDynamicRadioButtonByText(WebDriver driver, String radioButtonByText) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByText);
        checkToDefaultCheckboxOrRadio(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByText);
    }

    // VALUE AT ROW
    public String getDynamicValueAtRowByText(WebDriver driver, String rowName) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_VALUE_AT_ROW_BY_TEXT, rowName);
        return getElementText(driver, CommonPageUI.DYNAMIC_VALUE_AT_ROW_BY_TEXT, rowName);
    }

    // MESSAGE
    public boolean isDynamicSuccessfulMessageDisplayed(WebDriver driver, String messageValue) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_MESSAGE, messageValue);
        return isElementDisplayed(driver, CommonPageUI.DYNAMIC_MESSAGE, messageValue);
    }

}
