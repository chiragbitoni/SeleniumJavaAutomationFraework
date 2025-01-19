package mescius.wijmo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import mescius.wijmo.common.BasePage;

public class BaseTest {
    protected WebDriver browser;
    protected BasePage basePage;
    protected String commonUrl = "http://127.0.0.1:8887/samples/";
    protected String controlCategory = "";
    protected String fileName = "";

    @BeforeClass
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void loadUrl(){
        browser.get(commonUrl+controlCategory+fileName);
    }

    @AfterClass
    public void closeBrowser() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        browser.quit();
    }

}
