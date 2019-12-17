package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BageSectionComponent {
    private final String BestSeller = "Best Seller";
    private WebElement parent;

    public BageSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected List<WebElement> bageElements() {
        return parent.findElements(By.cssSelector(".a-badge-text"));
    }

    public String getText() {
        if (this.bageElements().isEmpty()) {
            return "";
        }
        return this.bageElements().get(0).getText();
    }

    public boolean isBestSeller() {
        return this.BestSeller.equals(getText());
    }
}
