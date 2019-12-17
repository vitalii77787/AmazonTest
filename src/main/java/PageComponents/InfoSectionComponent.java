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

    protected PriceSectionComponent getPriceComponent() {
        return new PriceSectionComponent(this.PriceSectionElement());
    }

    protected HeaderSectionComponent getHeaderSectionComponent() {
        return new HeaderSectionComponent(this.HeaderSectionElement());
    }

    public double getPrice() {
        return getPriceComponent().getPrice();
    }

    public String getName() {
        return getHeaderSectionComponent().getBookName();
    }

    public List<String> getAuthor() {
        return getHeaderSectionComponent().getAuthors();
    }

    public double getRating() {
        return getHeaderSectionComponent().getRating();
    }
}
