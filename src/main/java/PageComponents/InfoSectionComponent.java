package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InfoSectionComponent {
    private WebElement parent;

    public InfoSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement HeaderSectionElement() {
        return parent.findElement(By.cssSelector(".sg-row:first-of-type"));
    }

    protected WebElement PriceSectionElement() {
        return parent.findElement(By.cssSelector(".sg-row:nth-of-type(2)"));
    }

    public PriceSectionComponent GetPriceComponent() {
        return new PriceSectionComponent(this.PriceSectionElement());
    }

    public HeaderSectionComponent GetHeaderSectionComponent() {
        return new HeaderSectionComponent(this.HeaderSectionElement());
    }
}
