package ge.tbcitacademy.pages.Telerik;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class PricingProductBundlesTelerikPage extends BaseTelerikPage{
    public By showMoreButton = By.cssSelector("button.Btn");
    public By purchaseTitles = By.xpath("//div[@id='ContentPlaceholder1_C1037_Col00']//div[contains(@class,'Dev')]//div[@class='Purchase-title']");
    public By productsInclude = By.xpath("//dl/div/dt");
    public By devCraftUI = By.xpath("//div[@id='ContentPlaceholder1_C1037_Col00']//div[contains(@class,'Dev')]//div[@class='Purchase-title']/h5[text()='DevCraft UI']//parent::div//following-sibling::div[@class='Purchase-details']//li");
    public By devCraftComplete = By.xpath("//div[@id='ContentPlaceholder1_C1037_Col00']//div[contains(@class,'Dev')]//div[@class='Purchase-title']/h5[text()='DevCraft Complete']//parent::div//following-sibling::div[@class='Purchase-details']//li");
    public By devCraftUltimate = By.xpath("//div[@id='ContentPlaceholder1_C1037_Col00']//div[contains(@class,'Dev')]//div[@class='Purchase-title']/h5[text()='DevCraft Ultimate']//parent::div//following-sibling::div[@class='Purchase-details']//li");
    public By offerNames = By.cssSelector("#ContentPlaceholder1_C1037_Col00");
    public SelenideElement devCraftCompletePrice = $x("//div[@id='ContentPlaceholder1_C1037_Col00']/div[@class='Purchase-featured']//div[@class='Purchase-price']/div[@class='Purchase-price-inner u-fs60 u-c-black js-mobile-subtitle']"),
    devCraftBuyButton = $x("//a[@href='https://store.progress.com/configure-purchase?skuId=10016']");

}
