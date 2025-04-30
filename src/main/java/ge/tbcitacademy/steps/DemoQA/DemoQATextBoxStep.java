package ge.tbcitacademy.steps.DemoQA;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.DemoQA.DemoQATextBoxPage;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static ge.tbcitacademy.data.Constants.*;

public class DemoQATextBoxStep {
    DemoQATextBoxPage demoQATextBoxPage = new DemoQATextBoxPage();

    public DemoQATextBoxStep fillInputs(){
        SelenideElement userNameElement = $(demoQATextBoxPage.userName);
        userNameElement.setValue(USER_NAME);
        SelenideElement userEmailElement = $(demoQATextBoxPage.userEmail);
        userEmailElement.setValue(USER_EMAIL);
        SelenideElement currentAddressElement = $(demoQATextBoxPage.currentAddress);
        currentAddressElement.setValue(CURRENT_ADDRESS);
        SelenideElement permanentAddressElement = $(demoQATextBoxPage.permanentAddress);
        permanentAddressElement.setValue(PERMANENT_ADDRESS);

        return this;
    }

    public DemoQATextBoxStep clickSubmitButton(){
        SelenideElement submitButtonElement = $(demoQATextBoxPage.submitButton);
        submitButtonElement.click();

        return this;
    }

    public DemoQATextBoxStep validateResult(){
        ElementsCollection outputCollectionElements = $(demoQATextBoxPage.outputCollection).$$(byTagName("p"));
        outputCollectionElements.shouldHave(CollectionCondition.texts(USER_NAME, USER_EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS));

        System.out.println("I do not want conflict");

        return this;
    }
}
