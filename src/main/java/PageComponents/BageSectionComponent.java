package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BageSectionComponent {
    private WebElement parent;

    public BageSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement BageElement() {
        return parent.findElement(By.cssSelector(".a-badge-text"));
    }

    public String GetText() {
        return this.BageElement().getText();
    }
}
