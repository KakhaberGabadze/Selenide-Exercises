import ge.tbcitacademy.steps.DemoQA.DemoQATextBoxStep;
import ge.tbcitacademy.steps.Telerik.BaseTelerikStep;
import ge.tbcitacademy.steps.Telerik.PricingIndividualProductsTelerikStep;
import ge.tbcitacademy.steps.Telerik.PricingProductBundlesTelerikStep;
import ge.tbcitacademy.steps.TheInternet.TheInternetCheckBoxesStep;
import ge.tbcitacademy.steps.TheInternet.TheInternetDropDownStep;
import ge.util.helperFunction;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

public class SelenideTests extends BaseBeforeAfterTest{
    BaseTelerikStep baseTelerikStep;
    PricingIndividualProductsTelerikStep pricingIndividualProductsTelerikStep;
    PricingProductBundlesTelerikStep pricingProductBundlesTelerikStep;
    TheInternetCheckBoxesStep theInternetCheckBoxesStep;
    TheInternetDropDownStep theInternetDropDownStep;
    DemoQATextBoxStep demoQATextBoxStep;

    @Test
    public void validateBundleOffers() {
        open(TELERIK_URL);
        baseTelerikStep = new BaseTelerikStep();
        pricingProductBundlesTelerikStep = new PricingProductBundlesTelerikStep();
//        getWebDriver().manage().window().maximize();
        baseTelerikStep.goToPricingPage();

        pricingProductBundlesTelerikStep.clickShowMoreButton();

        helperFunction.productIncludedDots(ISSUE_ESCALATION);
        helperFunction.productIncludedDots(KENDO_UI_FOR_JQUERY);
        helperFunction.productIncludedDots(TELERIK_REPORTING);
        helperFunction.productIncludedDots(ACCESS_TO_ON_DEMAND_VIDEOS);

        pricingProductBundlesTelerikStep.EndToEndReportManagementSolution();

        pricingProductBundlesTelerikStep.telerikReportServer();

        pricingProductBundlesTelerikStep.stickyValidate();
    }

    @Test
    public void validateIndividualOffers() {
        open(TELERIK_URL);
        baseTelerikStep = new BaseTelerikStep();
        pricingIndividualProductsTelerikStep = new PricingIndividualProductsTelerikStep();

        baseTelerikStep.goToPricingPage();

        pricingIndividualProductsTelerikStep.clickIndividualProducsButton();

        pricingIndividualProductsTelerikStep.imageCheckOnHover();

        pricingIndividualProductsTelerikStep.defaultDropDownsValidation();

        pricingIndividualProductsTelerikStep.prioritySupportPricesValidation();
    }

    @Test
    public void checkBoxTest() {
        open(THE_INTERNET_CHECK_BOXES_URL);
        theInternetCheckBoxesStep = new TheInternetCheckBoxesStep();

        theInternetCheckBoxesStep.clickCheckbox1();

        theInternetCheckBoxesStep.checkCheckboxesCheckedStatus();
    }

    @Test
    public void dropDownTest() {
        open(THE_INTERNET_DROP_DOWN_URL);
        theInternetDropDownStep = new TheInternetDropDownStep();

        theInternetDropDownStep.checkDefaultDropDownOption();

        theInternetDropDownStep.selectOption2();

        theInternetDropDownStep.checkOption2SelectStatus();
    }

    @Test
    public void collectionsTest() {
        open(DEMOQA_TEXT_BOX_URL);
        demoQATextBoxStep = new DemoQATextBoxStep();

        demoQATextBoxStep.fillInputs();

        demoQATextBoxStep.clickSubmitButton();

        demoQATextBoxStep.validateResult();
    }
}
