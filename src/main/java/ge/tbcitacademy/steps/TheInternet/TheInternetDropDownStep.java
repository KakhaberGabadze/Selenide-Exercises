package ge.tbcitacademy.steps.TheInternet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.TheInternet.TheInternetDropDownPage;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetDropDownStep {
    TheInternetDropDownPage theInternetDropDownPage = new TheInternetDropDownPage();

    public TheInternetDropDownStep checkDefaultDropDownOption(){
        SelenideElement defaultEmenet = $(theInternetDropDownPage.defaultElement);
        defaultEmenet.shouldBe(Condition.selected);

        return this;
    }

    public TheInternetDropDownStep selectOption2(){
        SelenideElement dropDownElement = $(theInternetDropDownPage.dropDown);
        SelenideElement option2Element = $(theInternetDropDownPage.option2);

        dropDownElement.click();
//        dropDownElement.selectOption("Option 2");
        option2Element.click();

        return this;
    }

    public TheInternetDropDownStep checkOption2SelectStatus(){
        SelenideElement option2Element = $(theInternetDropDownPage.option2);
        option2Element.shouldBe(Condition.selected);
        option2Element.shouldBe(Condition.not(Condition.disabled));

        return this;
    }
}
