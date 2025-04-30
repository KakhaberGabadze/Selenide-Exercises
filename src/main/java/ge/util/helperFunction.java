package ge.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class helperFunction {
    public static void productIncludedDots(String xPath){
        ElementsCollection productsInclude = $$x("//dl/div/dt");
        List<String> purchaseTitles = $$x("//div[@id='ContentPlaceholder1_C1037_Col00']//div[contains(@class,'Dev')]//div[@class='Purchase-title']").texts();

        SelenideElement product = productsInclude.findBy(Condition.text(xPath));
        ElementsCollection productDots = productsInclude.findBy(Condition.text(xPath)).parent().$$x(".//dd");
        System.out.println("----------------------------");
        for (int i = 0; i< productDots.size(); i++){
            if (productDots.get(i).text().equalsIgnoreCase("●")){
                System.out.println(purchaseTitles.get(i) + " - supports - " + product.text());
            }
        }
        System.out.println("selenide2 conflict 1");
    }
}
