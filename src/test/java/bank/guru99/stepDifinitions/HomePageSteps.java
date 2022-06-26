package bank.guru99.stepDifinitions;

import commons.DataUtil;
import org.junit.Assert;
import pageObjects.PageGeneratorManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;

public class HomePageSteps {
    WebDriver driver;
    HomePageObject homePage;
    String customerName, gender, dateOfBirth, address, city, state, pinNumber, phoneNumber, email, password;
    DataUtil dataFaker;

    public HomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        homePage = PageGeneratorManager.getHomePage(driver);
        dataFaker = DataUtil.getData();
        customerName = dataFaker.getFullName();
        gender = "female";
        dateOfBirth = "06/03/1991";
        address = dataFaker.getAddress();
        city = dataFaker.getCity();
        state = dataFaker.getState();
        pinNumber = dataFaker.getPINNumber();
        phoneNumber = dataFaker.getNumber();
        email = dataFaker.getEmailAddress();
        password = dataFaker.getPassword();
    }

    @When("^Click on New Customer on sub menu$")
    public void click_on_new_customer_on_sub_menu() {
        homePage.clickOnSubMenuByText(driver, "New Customer");
    }

    @Then("^Verify all fields are enable$")
    public void verifyAllFieldsAreEnable() {
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "name"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "rad1"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "dob"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "city"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "state"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "pinno"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "telephoneno"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "emailid"));
        Assert.assertTrue(homePage.isFieldByNameDisplayed(driver, "password"));
    }

    @Then("^Input to Customer Name textbox$")
    public void input_to_customer_name_textbox() {
        homePage.inputToTextboxByName(driver, "name", customerName);

    }

    @Then("^Click on Gender radio button$")
    public void click_on_gender_radio_button() {
        homePage.inputToTextboxByName(driver, "rad1", gender);

    }

    @Then("^Input to Date of Birth textbox$")
    public void input_to_date_of_birth() {
        homePage.inputToDOBTextboxByName(driver, "dob", dateOfBirth);

    }

    @Then("^Input to Address textbox$")
    public void input_to_address_textbox() {
        homePage.inputToAddressTextbox(driver, address);

    }

    @Then("^Input to City textbox$")
    public void input_to_city_textbox() {
        homePage.inputToTextboxByName(driver, "city", city);

    }

    @Then("^Input to State textbox$")
    public void input_to_state_textbox() {
        homePage.inputToTextboxByName(driver, "state", state);

    }

    @Then("^Input to PIN textbox$")
    public void input_to_pin_textbox() {
        homePage.inputToTextboxByName(driver, "pinno", pinNumber);

    }

    @Then("^Input to Mobile Number textbox$")
    public void input_to_mobile_number_textbox() {
        homePage.inputToTextboxByName(driver, "telephoneno", phoneNumber);

    }

    @Then("^Input to Email textbox$")
    public void input_to_email_textbox() {
        homePage.inputToTextboxByName(driver, "emailid", email);

    }

    @Then("^Input to Password textbox$")
    public void input_to_password_textbox() {
        homePage.inputToTextboxByName(driver, "password", password);

    }

    @Then("^Click on Submit button$")
    public void click_on_submit_button() {
        homePage.clickOnButtonByName(driver, "sub");

    }

    @And("^Successful message is displayed$")
    public void successful_page_is_displayed() {
        Assert.assertTrue(homePage.theSuccessfulMessageIsDisplayed(driver, "Customer Registered Successfully!!!"));

    }


    @And("^Verify all output data display same as input data$")
    public void verifyAllOutputDataDisplaySameAsInputData() {
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Customer Name"), customerName);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Gender"), gender);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Birthdate"), dateOfBirth);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Address"), address);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "City"), city);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "State"), state);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Pin"), pinNumber);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Mobile No."), phoneNumber);
        Assert.assertEquals(homePage.getInfoValueByText(driver, "Email"), email);
    }
}
