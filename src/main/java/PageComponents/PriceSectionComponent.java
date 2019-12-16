package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.PageObjectHelper.ClearStringFromSymbols;
import static Utils.PageObjectHelper.TryParseDouble;

public class PriceSectionComponent {
    private WebElement parent;

    public PriceSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement PriceElement() {
        return this.parent.findElement(By.cssSelector(".sg-col-inner>div:first-of-type>div:nth-of-type(2)>div>a>span:first-of-type>span:first-of-type"));
    }

    public Double GetPrice() {
        double price = 0.0;
        String clearedString = ClearStringFromSymbols(this.PriceElement().getText());
        return TryParseDouble(clearedString, price);
    }
}
