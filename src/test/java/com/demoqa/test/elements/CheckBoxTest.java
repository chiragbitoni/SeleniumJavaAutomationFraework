package com.demoqa.test.elements;

import com.demoqa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;


public class CheckBoxTest extends BaseTest {
    /*
   Test Case ID: TC002
   Test Summary: Verify selecting and deselecting checkboxes after pressing the expand/collapse button.
   */
    private String actual = "";
    private String expected = "You have selected :desktopnotescommandsdownloadswordFileexcelFile";
    @Test
    public void TC002(){
        homePage.goToElements();
        elementsPage.clickCheckBoxCard();
        basePage.find(elementsPage.homeCheckbox).click();
        basePage.find(elementsPage.homeExpandButton).click();
        basePage.find(elementsPage.documentsCheckbox).click();
        for(WebElement outputCard : basePage.findElements(elementsPage.checkboxPageOutput)){
            actual += outputCard.getText();
        };
        Assert.assertEquals(actual,expected);
    }
    /*
      Test Case ID: TC003
      Test Summary: Verify checkbox state changes correctly after pressing checking/unchecking.
      */

    @Test
    public void TC003(){
        actual = "";
        expected = "truetruetruetrue";
        homePage.goToElements();
        elementsPage.clickCheckBoxCard();
        basePage.find(elementsPage.homeCheckbox).click();
        basePage.find(elementsPage.homeExpandButton).click();
        basePage.find(elementsPage.documentsCheckbox).click();
        actual = String.valueOf(basePage.find(elementsPage.homeCheckbox).findElement(By.tagName("svg")).getDomAttribute("class").contains(("rct-icon-half-check")));
        actual += String.valueOf(basePage.find(elementsPage.desktopCheckbox).findElement(By.tagName("svg")).getDomAttribute("class").contains(("rct-icon-check")));
        actual += String.valueOf(basePage.find(elementsPage.documentsCheckbox).findElement(By.tagName("svg")).getDomAttribute("class").contains(("rct-icon-uncheck")));
        actual += String.valueOf(basePage.find(elementsPage.downloadsCheckbox).findElement(By.tagName("svg")).getDomAttribute("class").contains(("rct-icon-check")));
        Assert.assertEquals(actual,expected);
    }
}
