package ge.tbcitacademy.steps.Telerik;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.Telerik.TelerikSupportDemosPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TelerikSupportDemosStep extends BaseTelerikStep{
    TelerikSupportDemosPage telerikSupportDemosPage = new TelerikSupportDemosPage();

    public TelerikSupportDemosStep purpleHoverValidation(){
        ElementsCollection webCardsElements = telerikSupportDemosPage.webCards;
        webCardsElements.stream().forEach(el -> el.hover().shouldHave(cssValue("background-color", "rgba(40, 46, 137, 0.75)")));

        return this;
    }

    public TelerikSupportDemosStep UIForVueDemosValidation(){
        SelenideElement vueDemosElement = telerikSupportDemosPage.vueDemos;
        SelenideElement findElement = vueDemosElement.hover().$$(byTagName("a")).find(Condition.exactText("UI for Vue demos"));
        findElement.hover().shouldHave(Condition.text("UI for Vue demos"));

        return this;
    }

    public TelerikSupportDemosStep desktopSectionStoreValidation(){
        SelenideElement desktopCardsElement = telerikSupportDemosPage.desktopCards;
        ElementsCollection microsoftBuyAvailable = desktopCardsElement.findAll(byAttribute("src", "/sfimages/default-source/productsimages/ui-for-xamarin/get-it-from-microsoft.png?Status=Temp&sfvrsn=95fd668b_2"));
        microsoftBuyAvailable.shouldBe(CollectionCondition.size(2));

        return this;
    }

    public TelerikSupportDemosStep mobileSectionStoreValidation(){
        ElementsCollection telerikUIForXamarinElements = telerikSupportDemosPage.telerikUIForXamarin;
        ElementsCollection filteredLinks = telerikUIForXamarinElements.filterBy(attributeMatching("href",
                ".*(apple\\.com|play\\.google\\.com|microsoft\\.com).*"));
        filteredLinks.shouldBe(CollectionCondition.size(3));

        return this;
    }

    public TelerikSupportDemosStep linksSectionFixedValidation(){
        SelenideElement offerNamesElementsElement = telerikSupportDemosPage.offerNamesElements;
        boolean isDisp;
        long lastHeight = executeJavaScript("return document.body.scrollHeight");
        long currentScroll = 0;
        while (currentScroll < lastHeight) {
            executeJavaScript("window.scrollBy(0, 200)");
            isDisp = offerNamesElementsElement.isDisplayed();
            System.out.println(isDisp);
            offerNamesElementsElement.shouldBe(visible);
            offerNamesElementsElement.shouldBe(appear);
            currentScroll += 200;
        }

        return this;
    }

    public TelerikSupportDemosStep scrollActivatesLinksValidation(){
        ElementsCollection sectionsElements = telerikSupportDemosPage.sections;
        ElementsCollection aforementionedLinksElements = telerikSupportDemosPage.aforementionedLinks;

        for (int i=0; i<sectionsElements.size(); i++){
            sectionsElements.get(i).scrollTo();
            sectionsElements.get(i).shouldBe(visible);
            aforementionedLinksElements.get(i).shouldHave(cssValue("background-color", "rgba(246, 247, 250, 1)"));
        }

        return this;
    }

    public TelerikSupportDemosStep aforementionedLinksCorrectSectionValidation(){
        ElementsCollection sectionsElements = telerikSupportDemosPage.sections;
        ElementsCollection aforementionedLinksElements = telerikSupportDemosPage.aforementionedLinks;


        for (int i=0; i<sectionsElements.size(); i++){
            aforementionedLinksElements.get(i).click();
            sectionsElements.get(i).shouldBe(visible);
            sectionsElements.get(i).shouldBe(appear);
        }

        return this;
    }
}
