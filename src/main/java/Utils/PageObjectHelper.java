package Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PageObjectHelper {
    public static void FillInput(WebElement target, String inputText) {
        target.click();
        target.clear();
        target.sendKeys(inputText);
    }

    public static void FillInputAndClickEnterKey(WebElement target, String inputText) {
        target.click();
        target.clear();
        target.sendKeys(inputText);
        target.sendKeys(Keys.ENTER);
    }

    public static Double TryParseDouble(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static String ClearStringFromSymbols (String value) {
        return value.replaceAll("[^A-Za-z0-9]","");
    }
}
