package mescius.wijmo.control.input;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mescius.wijmo.base.BaseTest;

public class InputTest extends BaseTest {
    private String expected, actual;

    @BeforeClass
    public void setControlCategory() {
        controlCategory = "Input/";
    }

    @Test
    public void TC_GL5149(){
        fileName = "TC_GL5149.html";
        loadUrl();
        expected = "truefalse";
        browser.findElement(By.id("theAutoComplete")).findElement(By.xpath("//div/div/div/span/button")).click();
        actual = String.valueOf(browser.findElement(By.xpath("//div[@wj-part='dropdown']")).isDisplayed());
        browser.findElement(By.xpath("//*[@id=\"theAutoComplete_dropdown\"]/div[3]")).click();
        actual += String.valueOf(browser.findElement(By.xpath("//div[@wj-part='dropdown']")).isDisplayed());
        Assert.assertEquals(actual, expected);
        closeBrowser();
        setUp();
    }

    @Test
    public void TC_GL5150() throws InterruptedException {
        fileName = "TC_GL5150.html";
        loadUrl();
        expected = "";
//        browser.
        closeBrowser();
    }
}
