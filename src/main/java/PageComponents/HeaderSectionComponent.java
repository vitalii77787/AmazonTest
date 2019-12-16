package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utils.PageObjectHelper.TryParseDouble;

public class HeaderSectionComponent {
    private WebElement parent;

    public HeaderSectionComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement NameElement() {
        return parent.findElement(By.cssSelector(".sg-col-inner>.a-section.a-spacing-none>h2>a>span"));
    }

    protected List<WebElement> AuthorElements() {
        return parent.findElements(By.cssSelector(".sg-col-inner>.a-section.a-spacing-none>.a-row.a-size-base.a-color-secondary>a"));
    }

    protected List<WebElement> RatingElement() {
        return parent.findElements(By.cssSelector(".sg-col-inner>div:nth-of-type(2) .a-popover-trigger a-declarative>i>span"));
    }

    public String GetBookName() {
        return this.NameElement().getText();
    }

    public List<String> GetAuthors() {
        List<String> authors = new ArrayList<String>();
        for (WebElement item : AuthorElements()) {
            authors.add(item.getText());
        }
        return authors;
    }

    public double GetRating() {
        double rating = 0.0;
        if (this.RatingElement().size() > 0) {
            String[] ratings = this.RatingElement().get(0).getText().split(" ");
            return TryParseDouble(ratings[0], rating);
        }
        return rating;
    }
}
