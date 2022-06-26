package guru99bank.stepDifinitions;

import commons.BasePage;
import commons.DataUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class CommonPageSteps extends BasePage {
    WebDriver driver;
    DataUtil dataFaker;
    String fakeCustomerName, fakeAddress, fakeCity, fakeState, fakePIN, fakeMobiNo, fakeEmail, fakePassword;
    String accountID, customerID;
    CommonPageObject commonPage;
    NewCustomerPageObject newCustomerPage;
    NewAccountPageObject newAccountPage;
    DepositPageObject depositPage;

    public CommonPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();

        dataFaker = DataUtil.getData();
        fakeCustomerName = dataFaker.getFullName();
        fakeAddress = dataFaker.getStreetAddress();
        fakeCity = dataFaker.getCity();
        fakeState = dataFaker.getState();
        fakePIN = dataFaker.getPINNumber();
        fakeMobiNo = dataFaker.getNumber();
        fakeEmail = dataFaker.getEmailAddress();
        fakePassword = dataFaker.getPassword();
        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

    @Given("^Open \"([^\"]*)\" page$")
    public void openPage(String pageName) {
        commonPage.openDynamicPageByText(driver, pageName);
        switch (pageName) {
            case "New Customer":
                newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
                break;
            case "New Account":
                newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
                break;
            case "Deposit":
                depositPage = PageGeneratorManager.getDepositPage(driver);
                break;
        }
    }

    @And("^Input into \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void inputIntoTextboxWithData(String textboxByText, String inputData) {
        switch (textboxByText) {
            case "Customer Name":
                inputData = fakeCustomerName;
                break;
            case "City":
                inputData = fakeCity;
                break;
            case "State":
                inputData = fakeState;
                break;
            case "PIN":
                inputData = fakePIN;
                break;
            case "Mobile Number":
                inputData = fakeMobiNo;
                break;
            case "E-mail":
                inputData = fakeEmail;
                break;
            case "Password":
                inputData = fakePassword;
                break;
//            case "Customer id":
//                inputData = customerID;
//                break;
            case "\n" +
                    "                            Initial deposit":
                inputData = dataFaker.getNumber();
                break;
        }
        commonPage.inputIntoDynamicTextboxByText(driver, textboxByText, inputData);

    }

    @And("^Click on \"([^\"]*)\" button$")
    public void clickOnButton(String buttonByText) {
        commonPage.clickOnDynamicButtonByValue(driver, buttonByText);
    }

    @And("^Get value at \"([^\"]*)\" row$")
    public void getValueAtRow(String rowName) {
        if (rowName.equals("Customer ID")) {
            customerID = commonPage.getDynamicValueAtRowByText(driver, rowName).trim();
            System.out.println("CUSTOMER ID: " + customerID);
        } else if (rowName.equals("Account No")) {
            accountID = commonPage.getDynamicValueAtRowByText(driver, rowName).trim();
            System.out.println("ACCOUNT No: " + accountID);
        }
    }

    @And("^Input into \"([^\"]*)\" text area with data \"([^\"]*)\"$")
    public void inputIntoTextAreaWithData(String textareaByText, String inputData) {
        if (textareaByText.equals("Address")) {
            inputData = fakeAddress;
        }
        commonPage.inputIntoDynamicTextarea(driver, textareaByText, inputData);
    }

    @And("^Click on 'Gender' radio button with value \"([^\"]*)\"$")
    public void clickOnRadioButtonWithValue(String radioButtonByValue) {
        commonPage.clickOnDynamicRadioButtonByValue(driver, radioButtonByValue);
    }

    @Then("^Successful message is displayed with \"([^\"]*)\"$")
    public void successfulMessageIsDisplayedWith(String expectedMessage) {
        Assert.assertTrue(commonPage.isDynamicSuccessfulMessageDisplayed(driver, expectedMessage));
    }

    @And("^The valid value displayed at \"([^\"]*)\" with data \"([^\"]*)\"$")
    public void theValidValueDisplayedAtWithData(String inputData, String outputData) {
        switch (inputData) {
            case "Customer Name":
                outputData = fakeCustomerName;
                break;
            case "Address":
                outputData = fakeAddress;
                break;
            case "City":
                outputData = fakeCity;
                break;
            case "State":
                outputData = fakeState;
                break;
            case "Pin":
                outputData = fakePIN;
                break;
            case "Mobile No.":
                outputData = fakeMobiNo;
                break;
            case "Email":
                outputData = fakeEmail;
                break;
        }
        Assert.assertEquals(commonPage.getDynamicValueAtRowByText(driver, inputData), outputData);
    }

    @And("^Select from \"([^\"]*)\" dropdown with value \"([^\"]*)\"$")
    public void selectFromDropdownWithValue(String dropdownByText, String selectedValue) {
        commonPage.selectFromDynamicDropdownByText(driver, dropdownByText, selectedValue);
    }

    @Then("^Verify that \"([^\"]*)\" textbox is enabled$")
    public void verifyThatTextboxIsEnabled(String textboxByText) {
        Assert.assertTrue(commonPage.isDynamicTextboxByTextEnabled(driver, textboxByText));
    }
    @And("^Verify that \"([^\"]*)\" textarea is enabled$")
    public void verifyThatTextareaIsEnabled(String textareaByText) {
        Assert.assertTrue(commonPage.isDynamicTextareaByTextEnabled(driver, textareaByText));
    }

    @And("^Verify that \"([^\"]*)\" radio button at 'Gender' is enabled$")
    public void verifyThatRadioButtonIsEnabled(String radioButtonByValue) {
        Assert.assertTrue(commonPage.isDynamicRadioButtonEnabled(driver, radioButtonByValue));
    }


}

