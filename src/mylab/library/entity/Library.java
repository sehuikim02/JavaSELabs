package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    // 제목으로 검색(첫 번째 일치 반환)
    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle() != null && b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    // 저자로 검색(여러 권 반환)
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor() != null && b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // ISBN으로 검색
    public Book findBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn() != null && b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    // ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null) {
            return b.checkOut();
        }
        return false;
    }

    // ISBN으로 도서 반납
    public boolean returnBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null && !b.isAvailable()) {
            b.returnBook();
            return true;
        }
        return false;
    }

    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    // 전체 도서 목록 반환
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    public String getName() {
        return name;
    }
}
