package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BageSectionComponent {
    private  final  String BestSeller = "Best Seller";
    private WebElement parent;

    public BageSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected List<WebElement> BageElements() {
        return parent.findElements(By.cssSelector(".a-badge-text"));
    }

    public String GetText() {
        if(this.BageElements().isEmpty()){
            return "";
        }
        return this.BageElements().get(0).getText();
    }

    public boolean IsBestSeller() {
        return this.BestSeller.equals(GetText());
    }
}
