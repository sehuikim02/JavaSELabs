package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String field;

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    @Override
    public String toString() {
        return getTitle() + " [����] �о�:" + field + ", " +
               getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}
