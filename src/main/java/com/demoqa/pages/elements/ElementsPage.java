package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPage extends BasePage {
    private By elementsHeaderCard = By.xpath("//div[@class='accordion']//div[text()='Elements']");
    private By textBoxCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[1]");
    private By checkboxCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[2]");
    private By radioButtonCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[3]");
    public By fullNameTextField = By.id("userName");
    public By emailTextField = By.id("userEmail");
    public By currentAddressField = By.id("currentAddress");
    public By permanentAddressField = By.id("permanentAddress");
    public By submitButton = By.id("submit");
    public By outputDiv = By.id("output");
    public By homeCheckbox = By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']");
    public By desktopCheckbox = By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']");
    public By homeExpandButton = By.xpath("//div[@id=\"tree-node\"]//span//button");
    public By documentsCheckbox = By.xpath("//label[@for='tree-node-documents']//span[@class='rct-checkbox']");
    public By downloadsCheckbox = By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']");
    public By checkboxPageOutput = By.xpath("//div[@id='result']//span");
    public By yesRadioButton = By.xpath("//input[@id='yesRadio']");
    public By radioButtonOutput = By.xpath("//p/span");
    public By impressiveRadioButton = By.xpath("//input[@id='impressiveRadio']");
    public void clickElementsHeaderCard(){
        scrollToElementJS(elementsHeaderCard);
        click(elementsHeaderCard);
    }
    public void clickTextBoxCard(){
        scrollToElementJS(textBoxCard);
        click(textBoxCard);
    }
    public void clickCheckBoxCard(){
        scrollToElementJS(checkboxCard);
        click(checkboxCard);
    }
    public void clickRadioButtonCard(){
        scrollToElementJS(radioButtonCard);
        click(radioButtonCard);
    }
}
