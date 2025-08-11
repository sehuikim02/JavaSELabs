package mylab.book.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Publication {
    protected String title;
    protected int pages;
    protected int price;
    protected LocalDate publishDate;

    public Publication(String title, int pages, int price, String publishDate) {
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.publishDate = LocalDate.parse(publishDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract String toString();
}
