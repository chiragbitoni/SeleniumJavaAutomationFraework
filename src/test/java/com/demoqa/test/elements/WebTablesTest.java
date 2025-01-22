package com.demoqa.test.elements;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;

public class WebTablesTest extends BaseTest {
    /*
       Test Case ID: TC005
       Test Summary: Verify that a user can add, edit, and delete records in the table.
        */
    private String actual = "";
    private String rowData = "";
    private String expected = "ChiragBitoni23chiragbitoni4994@gmail.com70000000ITChiragBitoni23chiragbitoni4994@gmail.com70000000Developer Tools";
    @Test
    public void TC005(){
        homePage.goToElements();
        elementsPage.clickWebTablesCard();
        basePage.find(elementsPage.addButton).click();
        basePage.setText(elementsPage.firstName, "Chirag");
        basePage.setText(elementsPage.lastName, "Bitoni");
        basePage.setText(elementsPage.userEmail, "chiragbitoni4994@gmail.com");
        basePage.setText(elementsPage.age, "23");
        basePage.setText(elementsPage.salary, "70000000");
        basePage.setText(elementsPage.department, "IT");
        basePage.find(elementsPage.submitButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItems)){
            actual += items.getText().trim();
        };
        actual = actual.replaceAll("\\n","");
        basePage.find(elementsPage.fourthRowEditButton).click();
        basePage.setText((elementsPage.department), "Developer Tools");
        basePage.find(elementsPage.submitButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItems)){
            rowData += items.getText().trim();
        };
        actual += rowData.replaceAll("\\n","");
        basePage.find(elementsPage.fourthRowDeleteButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItems)){
            actual += items.getText().trim();
        };
        Assert.assertEquals(actual,expected);
    }
}
