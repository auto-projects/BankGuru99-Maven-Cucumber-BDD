package pageObjects;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

public class AccessDetailsPageObject extends BasePage {
    WebDriver driver;

    public AccessDetailsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject openLoginPage(WebDriver driver) {
        openPageUrl(driver, GlobalConstants.LOGIN_PAGE);
        return PageGeneratorManager.getLoginPage(driver);
    }
}
