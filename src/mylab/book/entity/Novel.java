package mylab.book.entity;

public class Novel extends Publication {
    private String author;
    private String genre;

    public Novel(String title, String author, String genre, int pages, int price, String publishDate) {
        super(title, pages, price, publishDate);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [�Ҽ�] ����:%s, �帣:%s, %d��, %,d��, ������:%s",
                title, author, genre, pages, price, publishDate);
    }
}
