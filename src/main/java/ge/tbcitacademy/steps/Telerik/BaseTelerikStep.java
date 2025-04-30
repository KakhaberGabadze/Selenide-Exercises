package ge.tbcitacademy.steps.Telerik;

import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.Telerik.BaseTelerikPage;

import static com.codeborne.selenide.Selenide.$;

public class BaseTelerikStep {
    protected BaseTelerikPage baseTelerikPage = new BaseTelerikPage();

    public BaseTelerikStep goToPricingPage(){
        SelenideElement pricingElement = $(baseTelerikPage.pricingAnchor);
        pricingElement.click();
        return this;
    }
}
