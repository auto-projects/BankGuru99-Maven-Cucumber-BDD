package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends BasePage {
    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
