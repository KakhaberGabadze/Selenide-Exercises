package ge.tbcitacademy.steps.Telerik;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.Telerik.PricingIndividualProductsTelerikPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PricingIndividualProductsTelerikStep extends BaseTelerikStep{
    PricingIndividualProductsTelerikPage pricingIndividualProductsTelerikPage = new PricingIndividualProductsTelerikPage();

    public PricingIndividualProductsTelerikStep clickIndividualProducsButton(){
        SelenideElement individualProductsButtonElement = $(pricingIndividualProductsTelerikPage.individualProductsButton);
        individualProductsButtonElement.click();

        return this;
    }

    public PricingIndividualProductsTelerikStep imageCheckOnHover(){
        SelenideElement kendoNinjaImgElement = $(pricingIndividualProductsTelerikPage.kendoNinjaImg);
        SelenideElement kendoReactElement = $(pricingIndividualProductsTelerikPage.kendoReact);
        kendoReactElement.hover();
        kendoNinjaImgElement.shouldBe(visible);
        SelenideElement kendoUI = $(pricingIndividualProductsTelerikPage.kendoUI);
        kendoUI.hover();
        kendoNinjaImgElement.shouldBe(visible);

        return this;
    }

    public PricingIndividualProductsTelerikStep defaultDropDownsValidation(){
        $(pricingIndividualProductsTelerikPage.kendoReactDropDown).shouldHave(Condition.text(Constants.PRIORITY_SUPPORT));
        $(pricingIndividualProductsTelerikPage.kendoUIDropDown).shouldHave(Condition.text(Constants.PRIORITY_SUPPORT));

        return this;
    }

    public PricingIndividualProductsTelerikStep prioritySupportPricesValidation(){
        $(pricingIndividualProductsTelerikPage.kendoReactDropDown).click();
        SelenideElement kendoReactPrioritySupportPriceElement = $(pricingIndividualProductsTelerikPage.kendoReactPrioritySupportPrice);
        kendoReactPrioritySupportPriceElement.shouldHave(text(Constants.KENDO_REACT_PRIORITY_SUPPORT_PRICE));
        $(pricingIndividualProductsTelerikPage.kendoUIDropDown).click();
        SelenideElement kendoUIPrioritySupportPriceElement = $(pricingIndividualProductsTelerikPage.kendoUIPrioritySupportPrice);
        kendoUIPrioritySupportPriceElement.shouldHave(text(Constants.KENDO_UI_PRIORITY_SUPPORT_PRICE));

        return this;
    }
}
