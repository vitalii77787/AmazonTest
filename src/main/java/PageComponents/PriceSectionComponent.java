package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.PageObjectHelper.clearStringFromSymbols;
import static Utils.PageObjectHelper.tryParseDouble;

public class PriceSectionComponent {
    private WebElement parent;

    public PriceSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement priceElement() {
        return this.parent.findElement(By.cssSelector(".sg-col-inner>div:first-of-type>div:nth-of-type(2)>div>a>span:first-of-type>span:first-of-type"));
    }

    public Double getPrice() {
        double price = 0.0;
        String clearedString = clearStringFromSymbols(this.priceElement().getText());
        return tryParseDouble(clearedString, price);
    }
}
