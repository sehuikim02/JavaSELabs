package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String subject;

    public ReferenceBook(String title, String subject, int pages, int price, String publishDate) {
        super(title, pages, price, publishDate);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("%s [����] �о�:%s, %d��, %,d��, ������:%s",
                title, subject, pages, price, publishDate);
    }
}
