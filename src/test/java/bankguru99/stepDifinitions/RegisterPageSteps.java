package bankguru99.stepDifinitions;

import commons.DataUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class RegisterPageSteps {
    WebDriver driver;
    RegisterPageObject registerPage;
    AccessDetailsPageObject accessDetailsPage;
    LoginPageObject loginPage;
    DataUtil dataFaker;
    String email;
    static String userID, password;

    public RegisterPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        dataFaker = DataUtil.getData();
        email = dataFaker.getEmailAddress();
    }

    @When("^Click on Here button$")
    public void click_on_here_button() {
        loginPage.clickOnHereButton();
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Then("^Close the Ads$")
    public void click_on_close_button_on_the_ads() {
        registerPage.closeAdsPopup();
    }

    @And("^Input into 'Email ID' textbox$")
    public void inputIntoEmailIDTextbox() {
        registerPage.inputToEmailTextbox(email);

    }

    @And("^Click on 'Submit' button$")
    public void clickOnSubmitButton() {
        registerPage.clickOnSubmitButton();
        accessDetailsPage = PageGeneratorManager.getAccessDetailsPage(driver);
    }

    @And("^Get value at 'User ID :' row$")
    public void getValueAtUserIDRow() {
        userID = registerPage.getUsernameInformation();
    }

    @And("^Get value at 'Password :' row$")
    public void getValueAtPasswordRow() {
        password = registerPage.getPasswordInformation();
    }

    @Then("^Open Login Page$")
    public void openLoginPage() {
        accessDetailsPage.openLoginPage(driver);
    }


}
