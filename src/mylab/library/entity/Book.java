package mylab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    public Book() {
//        this.isAvailable = true;
    }

    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // ���� ���� - ������ ������ ��� isAvailable�� false�� �����ϰ�, true ��ȯ
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // ���� �ݳ� - isAvailable�� true�� ����
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
    	String availText;
    	if (isAvailable) {
    	    availText = "����";
    	} else {
    	    availText = "���� ��";
    	}
    	
        return String.format("å ����: %s\t����: %s\tISBN: %s\t���ǳ⵵: %d\n���� ���� ����: %s",
                title, author, isbn, publishYear, availText);
    }
}
