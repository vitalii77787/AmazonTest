package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    protected PriceSectionComponent GetPriceComponent() {
        return new PriceSectionComponent(this.PriceSectionElement());
    }

    protected HeaderSectionComponent GetHeaderSectionComponent() {
        return new HeaderSectionComponent(this.HeaderSectionElement());
    }

    public double GetPrice() {
        return GetPriceComponent().GetPrice();
    }

    public String GetName() {
        return GetHeaderSectionComponent().GetBookName();
    }

    public List<String> GetAuthor() {
        return GetHeaderSectionComponent().GetAuthors();
    }

    public double GetRating() {
        return GetHeaderSectionComponent().GetRating();
    }
}
