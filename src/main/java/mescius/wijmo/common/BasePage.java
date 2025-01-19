package mescius.wijmo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver browser;

    public void setDriver(WebDriver browser) {
        BasePage.browser = browser;
    }

}
