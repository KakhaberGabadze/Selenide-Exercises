package ge.tbcitacademy.steps.Telerik;

import com.codeborne.selenide.*;
import ge.tbcitacademy.pages.Telerik.PricingProductBundlesTelerikPage;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.*;

public class PricingProductBundlesTelerikStep extends BaseTelerikStep{
    PricingProductBundlesTelerikPage pricingProductBundlesTelerikPage = new PricingProductBundlesTelerikPage();

    public PricingProductBundlesTelerikStep clickShowMoreButton(){
        SelenideElement showMoreButtonElement = $(pricingProductBundlesTelerikPage.showMoreButton);
        showMoreButtonElement.scrollTo();
        Selenide.executeJavaScript("window.scrollBy(0, -200)");
//        showMoreButtonElement.shouldBe(visible).shouldBe(Condition.clickable).click();
        Selenide.executeJavaScript("arguments[0].click();", showMoreButtonElement);

        return this;
    }

    public List<String> purchaseTitlesTexts(){
        return $$(pricingProductBundlesTelerikPage.purchaseTitles).texts();
    }

    public PricingProductBundlesTelerikStep EndToEndReportManagementSolution(){
        ElementsCollection devCraftUIElement = $$(pricingProductBundlesTelerikPage.devCraftUI);
        devCraftUIElement
                .filterBy(Condition.text(END_TO_END_REPORTING_MANAGEMENT_SOLUTION))
                .shouldBe(CollectionCondition.empty);

        ElementsCollection devCraftCompleteElement = $$(pricingProductBundlesTelerikPage.devCraftComplete);
        devCraftCompleteElement
                .shouldHave(CollectionCondition.itemWithText("Mocking solution for rapid unit testing"))
                .filterBy(Condition.text(END_TO_END_REPORTING_MANAGEMENT_SOLUTION))
                .shouldBe(CollectionCondition.empty);

        ElementsCollection devCraftUltimateElement = $$(pricingProductBundlesTelerikPage.devCraftUltimate);
        devCraftUltimateElement.shouldHave(CollectionCondition.itemWithText(END_TO_END_REPORTING_MANAGEMENT_SOLUTION));

        return this;
    }

    public PricingProductBundlesTelerikStep telerikReportServer(){
        ElementsCollection productsIncludeElement = $$(pricingProductBundlesTelerikPage.productsInclude);
        ElementsCollection telerikReportServerDotsElements = productsIncludeElement.findBy(Condition.text(TELERIK_REPORT_SERVER)).parent().$$x(".//dd");
        telerikReportServerDotsElements.get($$(pricingProductBundlesTelerikPage.purchaseTitles).texts().indexOf(DEVCRAFT_ULTIMATE)).shouldHave(Condition.text(A_INSTANCE_WITH_15_USERS));

        return this;
    }

    public PricingProductBundlesTelerikStep stickyValidate(){
        SelenideElement offerNamesElements = $(pricingProductBundlesTelerikPage.offerNames);
        boolean isDisp = offerNamesElements.isDisplayed();
        System.out.println(isDisp);
        offerNamesElements.shouldBe(visible);
        Selenide.executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
        isDisp = offerNamesElements.isDisplayed();
        System.out.println(isDisp);
        offerNamesElements.shouldBe(visible);

        return this;
    }

    public double devCraftCompletePrice(){
        SelenideElement devCraftCompletePriceElement = pricingProductBundlesTelerikPage.devCraftCompletePrice;
        String devCraftOriginPrice = devCraftCompletePriceElement.text();
        String text1 = devCraftOriginPrice.replaceAll("[^\\d.]", "");

        return Double.parseDouble(text1);
    }

    public PricingProductBundlesTelerikStep clickBuyNowButton(){
        SelenideElement devCraftBuyButtonElement = pricingProductBundlesTelerikPage.devCraftBuyButton;
        devCraftBuyButtonElement.click();

        return this;
    }
}
