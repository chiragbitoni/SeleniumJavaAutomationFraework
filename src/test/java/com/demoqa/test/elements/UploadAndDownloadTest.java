package com.demoqa.test.elements;

import com.demoqa.base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static com.demoqa.pages.BasePage.delay;
import static utilities.Utilities.getSystemDownloadPath;

public class UploadAndDownloadTest extends BaseTest {
    //region TC012
    /*
        Test Case ID: TC012
        Test Case Summary: Validate that a user can successfully download a file from the DemoQA download page.
     */
    private String actual = "";
    private String expected = "falsetrue";
    File downloadedFile = new File(getSystemDownloadPath() + "\\sampleFile.jpeg");

    @Step("TC012")
    @Test
    public void TC012() {
        homePage.goToElements();
        elementsPage.clickUploadAndDownloadCard();
        if(downloadedFile.exists()){
            downloadedFile.delete();
        }
        actual = String.valueOf(downloadedFile.exists());
        basePage.click(uploadAndDownloadPage.downloadButton);
        delay(3000);
        actual += String.valueOf(downloadedFile.exists());
        Assert.assertEquals(actual, expected);
    }
    //endregion

    //region TC013
    /*
        Test Case ID: TC013
        Test Case Summary: Validate that a user can successfully upload a file on the DemoQA upload page.
     */
    @Step("TC013")
    @Test
    public void TC013() {
        actual = "";
        expected = "C:\\fakepath\\sampleFile.jpeg";
        homePage.goToElements();
        elementsPage.clickUploadAndDownloadCard();
        if(downloadedFile.exists()){
            basePage.find(uploadAndDownloadPage.chooseFileButton).sendKeys(getSystemDownloadPath()+"\\sampleFile.jpeg");
        }
        else{
            basePage.click(uploadAndDownloadPage.downloadButton);
            delay(3000);
            basePage.find(uploadAndDownloadPage.chooseFileButton).sendKeys(getSystemDownloadPath()+"\\sampleFile.jpeg");
        }
        actual = basePage.find(uploadAndDownloadPage.uploadedFilePath).getText();
        Assert.assertEquals(actual, expected);
    }
    //endregion
}
