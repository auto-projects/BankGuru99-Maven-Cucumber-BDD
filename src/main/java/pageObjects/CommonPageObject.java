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

    public boolean isDynamicTextboxByTextEnabled(WebDriver driver, String textboxByText) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_TEXT, textboxByText);
        return isElementEnabled(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_TEXT, textboxByText);
    }

    // TEXTAREA
    public void inputIntoDynamicTextarea(WebDriver driver, String textareaByText, String inputData) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, textareaByText);
        sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, inputData, textareaByText);
    }

    public boolean isDynamicTextareaByTextEnabled(WebDriver driver, String textareaByText) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, textareaByText);
        return isElementEnabled(driver, CommonPageUI.DYNAMIC_TEXT_AREA_BY_TEXT, textareaByText);
    }

    // BUTTON
    public void clickOnDynamicButtonByValue(WebDriver driver, String buttonByValue) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonByValue);
        clickOnElement(driver, CommonPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonByValue);
    }

    // RADIO BUTTON
    public void clickOnDynamicRadioButtonByValue(WebDriver driver, String radioButtonByValue) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByValue);
        checkToDefaultCheckboxOrRadio(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByValue);
    }
    public boolean isDynamicRadioButtonEnabled(WebDriver driver, String radioButtonByValue) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByValue);
        return isElementEnabled(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, radioButtonByValue);
    }

    // DROPDOWN
    public void selectFromDynamicDropdownByText(WebDriver driver, String dropdownByText, String selectedValue) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_DROPDOWN_BY_TEXT, dropdownByText);
        selectItemInDefaultDropdown(driver, CommonPageUI.DYNAMIC_DROPDOWN_BY_TEXT, selectedValue, dropdownByText);
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
