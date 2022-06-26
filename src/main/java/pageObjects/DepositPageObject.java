package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DepositPageObject extends BasePage {
    WebDriver driver;

    public DepositPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
