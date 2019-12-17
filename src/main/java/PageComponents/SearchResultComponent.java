package PageComponents;

import Models.BookModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultComponent {
    private WebElement parent;

    public SearchResultComponent(WebElement parent) {
        this.parent = parent;
    }

    protected WebElement bageElement() {
        return parent.findElement(By.cssSelector(".a-section.a-spacing-medium>.sg-row:first-of-type"));
    }

    protected WebElement infoSectionElement() {
        return parent.findElement(By.cssSelector(".a-section.a-spacing-medium>.sg-row>div:nth-of-type(2)>.sg-col-inner"));
    }

    protected BageSectionComponent getBage() {
        return new BageSectionComponent(this.bageElement());
    }

    protected InfoSectionComponent getInfo() {
        return new InfoSectionComponent(this.infoSectionElement());
    }

    public BookModel getBookModel() {
        BookModel book = new BookModel();
        book.setAuthor(getInfo().getAuthor());
        book.setBookName(getInfo().getName());
        book.setPrice(getInfo().getPrice());
        book.setRating(getInfo().getRating());
        book.setBestSeller(getBage().isBestSeller());
        return book;
    }
}
