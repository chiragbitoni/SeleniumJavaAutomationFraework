package com.demoqa.test.elements;

import com.demoqa.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckBoxTest extends BaseTest {
    /*
   Test Case ID: TC002
   Test Summary: Verify selecting and deselecting checkboxes after pressing the expand/collapse button.
   */
    private String actual = "";
    private String expected = "You have selected :desktopnotescommandsdownloadswordFileexcelFile";
    @Test
    public void TC002(){
        homePage.goToForms();
        elementsPage.clickElementsHeaderCard();
        elementsPage.clickCheckBoxCard();
        basePage.find(elementsPage.homeCheckbox).click();
        basePage.find(elementsPage.homeExpandButton).click();
        basePage.find(elementsPage.documentsCheckbox).click();
        for(WebElement outputCard : basePage.findElements(elementsPage.checkboxPageOutput)){
            actual += outputCard.getText();
        };
        Assert.assertEquals(actual,expected);
    }
}
