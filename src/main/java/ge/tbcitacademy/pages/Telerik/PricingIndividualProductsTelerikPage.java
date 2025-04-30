package ge.tbcitacademy.pages.Telerik;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static ge.tbcitacademy.data.Constants.INDIVIDUAL_PRODUCTS;

public class PricingIndividualProductsTelerikPage extends BaseTelerikPage{
    public By individualProductsButton = byTagAndText("button", INDIVIDUAL_PRODUCTS);
    public By kendoReact = By.xpath("//a[@href='https://store.progress.com/configure-purchase?skuId=10032']");
    public By kendoNinjaImg = By.xpath("//img[contains(@alt, 'Kendo Ninja')]");
    public By kendoUI = By.xpath("//a[@href='https://store.progress.com/configure-purchase?skuId=10035']");
    public By kendoReactDropDown = By.xpath("//h5[text()='KendoReact']//parent::div[@class='Purchase-title']//following-sibling::div[@class='Purchase-support']//button[@class='ComboBox-control']");
    public By kendoUIDropDown = By.xpath("//h5[text()='Kendo UI']//parent::div[@class='Purchase-title']//following-sibling::div[@class='Purchase-support']//button[@class='ComboBox-control']");
    public By kendoReactPrioritySupportPrice = By.xpath("//h5[text()='KendoReact']//parent::div[@class='Purchase-title']//following-sibling::div[@class='Purchase-support']//div[text()='Priority Support']//parent::div[@class='u-full']//following-sibling::div/span[@class='js-subscription']");
    public By kendoUIPrioritySupportPrice = By.xpath("//h5[text()='Kendo UI']//parent::div[@class='Purchase-title']//following-sibling::div[@class='Purchase-support']//div[text()='Priority Support']//parent::div[@class='u-full']//following-sibling::div/span[@class='js-subscription']");
}
