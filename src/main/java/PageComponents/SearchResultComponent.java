package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultComponent {
    private WebElement parent;

    public SearchResultComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement BageElement() {
        return parent.findElement(By.cssSelector(".a-section.a-spacing-medium>.sg-row:first-of-type"));
    }

    protected WebElement InfoSectionElement() {
        return parent.findElement(By.cssSelector(".a-section.a-spacing-medium>.sg-row>div:nth-of-type(2)>.sg-col-inner"));
    }

    public BageSectionComponent GetBage() {
        return new BageSectionComponent(this.BageElement());
    }

    public InfoSectionComponent GetInfo() {
        return new InfoSectionComponent(this.InfoSectionElement());
    }
}
