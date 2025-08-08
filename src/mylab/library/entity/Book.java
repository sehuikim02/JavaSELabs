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

    // 도서 대출 - 대출이 가능한 경우 isAvailable을 false로 변경하고, true 반환
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // 도서 반납 - isAvailable을 true로 변경
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
    	String availText;
    	if (isAvailable) {
    	    availText = "가능";
    	} else {
    	    availText = "대출 중";
    	}
    	
        return String.format("책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\n대출 가능 여부: %s",
                title, author, isbn, publishYear, availText);
    }
}
