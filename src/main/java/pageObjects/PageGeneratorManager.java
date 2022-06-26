package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static CommonPageObject getCommonPage(WebDriver driver) {
        return new CommonPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static AccessDetailsPageObject getAccessDetailsPage(WebDriver driver) {
        return new AccessDetailsPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
        return new NewCustomerPageObject(driver);
    }

    public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
        return new NewAccountPageObject(driver);
    }


}

