package Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageObjectHelper {
    public static void fillInput(WebElement target, String inputText) {
        target.click();
        target.clear();
        target.sendKeys(inputText);
    }

    public static void fillInputAndClickEnterKey(WebElement target, String inputText) {
        target.click();
        target.clear();
        target.sendKeys(inputText);
        target.sendKeys(Keys.ENTER);
    }

    public static Double tryParseDouble(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static String clearStringFromSymbols(String value) {
        final String regex = "[^\\d.,]+";
        final String string = value;
        final String substring = "";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        final String result = matcher.replaceAll(substring);
        return result;
    }
}
