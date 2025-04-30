package ge.tbcitacademy.pages.TheInternet;

import ge.tbcitacademy.data.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagAndText;

public class TheInternetDropDownPage {
    public By dropDown = By.cssSelector("#dropdown");
    public  By defaultElement = byTagAndText("option", Constants.PLEASE_SELECT_AN_OPTION);
    public By option2 = byTagAndText("option", "Option 2");
}
