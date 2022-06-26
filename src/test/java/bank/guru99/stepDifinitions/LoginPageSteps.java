package bank.guru99.stepDifinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;

public class LoginPageSteps {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;

    public LoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Then("^Input into 'UserID' textbox$")
    public void inputIntoUserIDTextbox() {
        loginPage.inputIntoUserIDTextbox(RegisterPageSteps.userID);
    }

    @And("^Input into 'Password' textbox$")
    public void inputIntoPasswordTextbox() {
        loginPage.inputIntoPasswordTextbox(RegisterPageSteps.password);
    }

    @And("^Click on 'LOGIN' button$")
    public void clickOnLOGINButton() {
        loginPage.clickOnLoginButton();
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @And("^Verify successful message displayed$")
    public void verifySuccessfulMessageDisplayed() {
        Assert.assertTrue(homePage.isSuccessfulMessageDisplayed());
        Assert.assertEquals(homePage.getSuccessfulMessage(), "Welcome To Manager's Page of Guru99 Bank");
    }

    @And("^Verify Manger Id displayed$")
    public void verifyMangerIdDisplayed() {
        Assert.assertTrue(homePage.isUserIDDisplayed());
        Assert.assertEquals(homePage.getMangerUserID(), "Manger Id : " + RegisterPageSteps.userID);
    }


}
