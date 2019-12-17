package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utils.PageObjectHelper.tryParseDouble;

public class HeaderSectionComponent {
    private WebElement parent;

    public HeaderSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement nameElement() {
        return parent.findElement(By.cssSelector(".sg-col-inner>.a-section.a-spacing-none>h2>a>span"));
    }

    protected List<WebElement> authorElements() {
        return parent.findElements(By.cssSelector(".sg-col-inner>.a-section.a-spacing-none>.a-row.a-size-base.a-color-secondary>a"));
    }

    protected List<WebElement> ratingElement() {
        return parent.findElements(By.cssSelector(".sg-col-inner>div:nth-of-type(2) .a-popover-trigger>i>span"));
    }

    public String getBookName() {
        return this.nameElement().getText();
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<String>();
        for (WebElement item : authorElements()) {
            authors.add(item.getText());
        }
        return authors;
    }

    public double getRating() {
        double rating = 0.0;
        if (!this.ratingElement().isEmpty()) {
            String[] ratings = this.ratingElement().get(0).getText().split(" ");
            return tryParseDouble(ratings[0], rating);
        }
        return rating;
    }
}
