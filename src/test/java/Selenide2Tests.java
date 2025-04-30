import ge.tbcitacademy.steps.Telerik.BaseTelerikStep;
import ge.tbcitacademy.steps.Telerik.PricingProductBundlesTelerikStep;
import ge.tbcitacademy.steps.Telerik.TelerikDevCraftCompleteBuyNowStep;
import ge.tbcitacademy.steps.Telerik.TelerikSupportDemosStep;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.TELERIK_URL;

public class Selenide2Tests extends BaseBeforeAfterTest{
    BaseTelerikStep baseTelerikStep = new BaseTelerikStep();
    TelerikSupportDemosStep telerikSupportDemosStep = new TelerikSupportDemosStep();
    PricingProductBundlesTelerikStep pricingProductBundlesTelerikStep = new PricingProductBundlesTelerikStep();
    TelerikDevCraftCompleteBuyNowStep telerikDevCraftCompleteBuyNowStep = new TelerikDevCraftCompleteBuyNowStep();

    @Test
    public void validateDemosDesign() {
        open(TELERIK_URL);
        telerikSupportDemosStep
                .purpleHoverValidation()
                .UIForVueDemosValidation()
                .desktopSectionStoreValidation()
                .mobileSectionStoreValidation()
                .linksSectionFixedValidation()
                .scrollActivatesLinksValidation()
                .aforementionedLinksCorrectSectionValidation();
    }

    @Test
    public void validateOrderMechanics() throws InterruptedException {
        open(TELERIK_URL);

        baseTelerikStep.goToPricingPage();

        double basePrice = pricingProductBundlesTelerikStep.devCraftCompletePrice();

        pricingProductBundlesTelerikStep.clickBuyNowButton();
        telerikDevCraftCompleteBuyNowStep.closeButtonClick();
        double price2 = telerikDevCraftCompleteBuyNowStep.unitPrice();

        Assert.assertEquals(basePrice, price2);

        telerikDevCraftCompleteBuyNowStep
                .correctSavingValidation()
                .subtotalValueValidation()
                .questionMarkHover()
                .totalDiscountValidation()
                .totalValueValidation()
                .clickContinueButton()
                .fillData()
                .backAndForward()
                .checkData();
    }
}
