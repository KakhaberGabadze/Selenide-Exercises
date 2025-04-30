package ge.tbcitacademy.steps.Telerik;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbcitacademy.pages.Telerik.TelerikDevCraftCompleteBuyNowPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.forward;

public class TelerikDevCraftCompleteBuyNowStep {
    TelerikDevCraftCompleteBuyNowPage telerikDevCraftCompleteBuyNowPage = new TelerikDevCraftCompleteBuyNowPage();

    public TelerikDevCraftCompleteBuyNowStep closeButtonClick(){
        SelenideElement closeButtonElement = telerikDevCraftCompleteBuyNowPage.closeButton;
        closeButtonElement.click();

        return this;
    }

    public double unitPrice(){
        SelenideElement unitPriceElement = telerikDevCraftCompleteBuyNowPage.unitPrice;
        String unitPriceText = unitPriceElement.text();
        String text2 = unitPriceText.replaceAll("[^\\d.]", "");

        return Double.parseDouble(text2);
    }

    public TelerikDevCraftCompleteBuyNowStep increaseQuantity(String quantity){
        SelenideElement quantityDropdownElement = telerikDevCraftCompleteBuyNowPage.quantityDropdown;
        quantityDropdownElement.click();
        SelenideElement quantityElement = $(byText(quantity));
        quantityElement.click();

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep correctSavingValidation() throws InterruptedException {
        double price = unitPrice();
        increaseQuantity("3");
        SelenideElement saveElement = telerikDevCraftCompleteBuyNowPage.save;
        double saveValue = price * 0.05;
        String savePrice = String.format("%.2f", saveValue);
        saveElement.shouldHave(text(savePrice));

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep subtotalValueValidation(){
        SelenideElement quantityDropdownElement = telerikDevCraftCompleteBuyNowPage.quantityDropdown;
        SelenideElement subtotalElement = telerikDevCraftCompleteBuyNowPage.subtotal;
        SelenideElement actualUnitPriceElement = telerikDevCraftCompleteBuyNowPage.actualUnitPrice;
        double actualQuantity = Double.parseDouble(quantityDropdownElement.text());
        String cleanedSubtotal = subtotalElement.text().replaceAll("[$,]", "");
        double subtotalPrice = Double.parseDouble(cleanedSubtotal);
        String cleanedActualPrice = actualUnitPriceElement.text().replaceAll("[$,]", "");
        double actualPrice = Math.round(Double.parseDouble(cleanedActualPrice) * actualQuantity * 100)/100.0;
        Assert.assertEquals(subtotalPrice, actualPrice);

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep questionMarkHover(){
        SelenideElement questionMarkElement = telerikDevCraftCompleteBuyNowPage.questionMark;
        questionMarkElement.hover();

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep totalDiscountValidation(){
        SelenideElement questionMarkDiscountElement = telerikDevCraftCompleteBuyNowPage.questionMarkDiscount;
        SelenideElement totalDiscountElement = telerikDevCraftCompleteBuyNowPage.totalDiscount;
        Assert.assertEquals(questionMarkDiscountElement.text(), totalDiscountElement.text());

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep totalValueValidation() throws InterruptedException {
        increaseQuantity("1");
        Thread.sleep(1000);
        double price = unitPrice();
        increaseQuantity("3");
        Thread.sleep(1000);
        System.out.println(price);
        SelenideElement quantityDropdownElement = telerikDevCraftCompleteBuyNowPage.quantityDropdown;
        double actualQuantity = Double.parseDouble(quantityDropdownElement.text());
        double total = (price * actualQuantity) - (price * 0.05 * actualQuantity);
        SelenideElement totalPriceElement = telerikDevCraftCompleteBuyNowPage.totalPrice;
        String totaPriceText = totalPriceElement.text();
        double totalPriceNumbers = Double.parseDouble(totaPriceText.replaceAll("[^\\d.]", ""));
        Assert.assertEquals(total, totalPriceNumbers);

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep clickContinueButton(){
        SelenideElement continueButtonElement = telerikDevCraftCompleteBuyNowPage.continueButton;
        continueButtonElement.click();

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep fillData(){
        SelenideElement fName = telerikDevCraftCompleteBuyNowPage.fName;
        fName.setValue("Kakhaber");
        SelenideElement lName = telerikDevCraftCompleteBuyNowPage.lName;
        lName.setValue("Gabadze");
        SelenideElement email = telerikDevCraftCompleteBuyNowPage.email;
        email.setValue("k.g@gmail.com");
        SelenideElement company = telerikDevCraftCompleteBuyNowPage.company;
        company.setValue("TBC");
        SelenideElement phone = telerikDevCraftCompleteBuyNowPage.phone;
        phone.setValue("032 227 27 27");
        SelenideElement address = telerikDevCraftCompleteBuyNowPage.address;
        address.setValue("Politkovskaya, 14");
        SelenideElement country = telerikDevCraftCompleteBuyNowPage.country;
        country.click();
        SelenideElement georgia = telerikDevCraftCompleteBuyNowPage.georgia;
        georgia.scrollTo();
        georgia.click();
//        country.setValue("Georgia");
        SelenideElement city = telerikDevCraftCompleteBuyNowPage.city;
        city.setValue("Tbilisi");
        SelenideElement zipCode = telerikDevCraftCompleteBuyNowPage.zipCode;
        zipCode.setValue("0159");

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep backAndForward(){
        back();
        forward();

        return this;
    }

    public TelerikDevCraftCompleteBuyNowStep checkData(){
        ElementsCollection form = telerikDevCraftCompleteBuyNowPage.form;
        form.stream().forEach(el -> el.shouldBe(empty));

        return this;
    }
}
