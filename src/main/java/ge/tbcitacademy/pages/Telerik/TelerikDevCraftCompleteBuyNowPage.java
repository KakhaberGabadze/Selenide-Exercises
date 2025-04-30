package ge.tbcitacademy.pages.Telerik;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TelerikDevCraftCompleteBuyNowPage extends BaseTelerikPage {
    public SelenideElement closeButton = $x("//i[@class='far fa-times label u-cp']"),
    unitPrice = $x("//span[@class='td-cell td-cell--data']/span"),
    quantityDropdown = $x("//div[@class='td-cell--data border-left']//kendo-dropdownlist"),
    save = $x("//div[@class='label label--grey sm-hidden e2e-item-licenses-savings']"),
    subtotal = $x("//div[@class='u-mt8 e2e-cart-item-subtotal sm-no-spacing td-cell td-cell--data']"),
    actualUnitPrice = $x("//span[@class='e2e-price-per-license page-body--success']"),
    questionMark = $x("//i[@class='far fa-question-circle tooltip-icon']"),
    questionMarkDiscount = $x("//span[@class='u-pr5 e2e-licenses-discounts']"),
    totalDiscount = $x("//span[@class='u-fr e2e-total-discounts-price']"),
    totalPrice = $x("//h4[@class='u-fr e2e-total-price']"),
    continueButton = $(byTagAndText("span", "Continue as Guest")),
    fName = $("#biFirstName"),
    lName = $("#biLastName"),
    email = $("#biEmail"),
    company = $("#biCompany"),
    phone = $("#biPhone"),
    address = $("#biAddress"),
    country = $x("//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"),
    georgia = $(withText("Georgia")),
    city = $("#biCity"),
    zipCode = $("#biZipCode");

    public ElementsCollection form = $$x("//div[@class='col-md-10']//input");
}
