package ge.tbcitacademy.steps.TheInternet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.TheInternet.TheInternetCheckBoxesPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TheInternetCheckBoxesStep {
    TheInternetCheckBoxesPage theInternetCheckBoxesPage = new TheInternetCheckBoxesPage();

    public TheInternetCheckBoxesStep clickCheckbox1(){
        SelenideElement checkBox1Element = $(theInternetCheckBoxesPage.checkBox1);
//        checkBox1Element.setSelected(true);
        checkBox1Element.click();

        return this;
    }

    public TheInternetCheckBoxesStep checkCheckboxesCheckedStatus(){
        ElementsCollection checkBoxElements = $$(theInternetCheckBoxesPage.checkBoxes);
        System.out.println(checkBoxElements.size());
        checkBoxElements.forEach(inp -> inp.shouldBe(checked));
        System.out.println("selenide2 conflict 2");
        return this;
    }
}
