package ge.tbcitacademy.pages.Telerik;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class TelerikSupportDemosPage extends BaseTelerikPage {
    public ElementsCollection webCards = $$x("//div[@id = 'ContentPlaceholder1_C329_Col00']//parent::div[@class='row u-mb8']//div[contains(@id, 'ContentPlaceholder1')]//*[contains(@class,'HoverImg')]"),
    telerikUIForXamarin = $("#ContentPlaceholder1_C340_Col01").findAll(byTagName("a")),
    sections = $$x("// div[@id='ContentPlaceholder1_C257_Col00']/h2"),
    aforementionedLinks = $$x("//div[@class='container']//a");

    public SelenideElement vueDemos = $x("//div[@id='ContentPlaceholder1_C329_Col00']//div[@class='LinkContainer']"),
    desktopCards = $x("//div[@id='ContentPlaceholder1_C337_Col00']/parent::div"),
    offerNamesElements = $x("//div[@class='container']");
}
