package Models;

import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private String bookName;
    private List<String> author;
    private double price;
    private double rating;
    private boolean isBestSeller;

    public BookModel(String bookName,
                     List<String> author,
                     double price,
                     double rating,
                     boolean isBestSeller) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.isBestSeller = isBestSeller;
    }

    public BookModel() {
        author = new ArrayList<>();
    }

    public String getBookName() {
        return bookName;
    }

    public List<String> getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

}
