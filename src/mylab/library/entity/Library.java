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

    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }

    // �������� �˻�(ù ��° ��ġ ��ȯ)
    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle() != null && b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    // ���ڷ� �˻�(���� �� ��ȯ)
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor() != null && b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // ISBN���� �˻�
    public Book findBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn() != null && b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    // ISBN���� ���� ����
    public boolean checkOutBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null) {
            return b.checkOut();
        }
        return false;
    }

    // ISBN���� ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null && !b.isAvailable()) {
            b.returnBook();
            return true;
        }
        return false;
    }

    // ���� ������ ���� ��� ��ȯ
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    // ��ü ���� ��� ��ȯ
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
