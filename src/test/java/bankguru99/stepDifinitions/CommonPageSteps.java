package bankguru99.stepDifinitions;

import commons.BasePage;
import commons.DataUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CommonPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageGeneratorManager;

public class CommonPageSteps extends BasePage {
    WebDriver driver;
    DataUtil dataFaker;
    String fakeCustomerName, fakeAddress, fakeCity, fakeState, fakePIN, fakeMobiNo, fakeEmail, fakePassword;
    String accountID, customerID;
    CommonPageObject commonPage;
    NewCustomerPageObject newCustomerPage;
    NewAccountPageObject newAccountPage;

    public CommonPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        dataFaker = DataUtil.getData();
        fakeCustomerName = dataFaker.getFullName();
        fakeAddress = dataFaker.getAddress();
        fakeCity = dataFaker.getCity();
        fakeState = dataFaker.getState();
        fakePIN = dataFaker.getPINNumber();
        fakeMobiNo = dataFaker.getNumber();
        fakeEmail = dataFaker.getEmailAddress();
        fakePassword = dataFaker.getPassword();
    }

    @Given("^Open \"([^\"]*)\" page$")
    public void openPage(String pageName) {
        commonPage.openDynamicPageByText(driver, pageName);
        if (pageName.equals("New Customer")) {
            newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
        } else if (pageName.equals("New Account")) {
            newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
        }

    }

    @And("^Input into \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void inputIntoTextboxWithData(String textboxByText, String inputData) {
        switch (textboxByText) {
            case "Customer Name":
                inputData = fakeCustomerName;
            case "City":
                inputData = fakeCity;
            case "State":
                inputData = fakeState;
            case "PIN":
                inputData = fakePIN;
            case "Mobile Number":
                inputData = fakeMobiNo;
            case "E-mail":
                inputData = fakeEmail;
            case "Password":
                inputData = fakePassword;
        }
       commonPage.inputIntoDynamicTextboxByText(driver, textboxByText, inputData);
    }

    @And("^Click on \"([^\"]*)\" button$")
    public void clickOnButton(String buttonByText) {
        commonPage.clickOnDynamicButtonByValue(driver, buttonByText);
    }

    @And("^Get value at \"([^\"]*)\" row$")
    public void getValueAtRow(String rowName) {
        customerID = commonPage.getDynamicValueAtRowByText(driver, rowName);
    }

    @And("^Input into \"([^\"]*)\" text area with data \"([^\"]*)\"$")
    public void inputIntoTextAreaWithData(String textareaByText, String inputData) {
        if (textareaByText.equals("Address")) {
            inputData = fakeAddress;
        }
        commonPage.inputIntoDynamicTextarea(driver, textareaByText, inputData);
    }
    @And("^Click on \"([^\"]*)\" radio button$")
    public void clickOnRadioButton(String radioButtonByText) {
        commonPage.selectDynamicRadioButtonByText(driver, radioButtonByText);
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
            case "Address":
                outputData = fakeAddress;
            case "City":
                outputData = fakeCity;
            case "State":
                outputData = fakeState;
            case "Pin":
                outputData = fakePIN;
            case "Mobile No.":
                outputData = fakeMobiNo;
            case "Email":
                outputData = fakeEmail;
        }
        Assert.assertEquals(commonPage.getDynamicValueAtRowByText(driver, inputData), outputData);
    }
}

