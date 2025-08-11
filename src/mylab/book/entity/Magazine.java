package mylab.book.entity;

public class Magazine extends Publication {
    private String issueFrequency;

    public Magazine(String title, String issueFrequency, int pages, int price, String publishDate) {
        super(title, pages, price, publishDate);
        this.issueFrequency = issueFrequency;
    }

    @Override
    public String toString() {
        return String.format("%s [잡지] 발행주기:%s, %d쪽, %,d원, 출판일:%s",
                title, issueFrequency, pages, price, publishDate);
    }
}
