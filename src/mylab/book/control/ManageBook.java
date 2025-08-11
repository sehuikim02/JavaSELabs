package mylab.book.control;

import java.util.ArrayList;
import mylab.book.entity.Publication;

public class ManageBook {
    private ArrayList<Publication> books = new ArrayList<>();

    public void addBook(Publication p) {
        books.add(p);
    }

    public void listBooks() {
        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, books.get(i).toString());
        }
    }

    public void adjustPrice(String title, double rate) {
        for (Publication p : books) {
            if (p.getTitle().equals(title)) {
                int oldPrice = p.getPrice();
                System.out.printf("%s ���� �� ����: %,d��%n", title, oldPrice);
                int newPrice = (int) (oldPrice * rate);
                p.setPrice(newPrice);
                System.out.printf("%s ���� �� ����: %,d��%n", title, newPrice);
                System.out.printf("����: %,d��%n", oldPrice - newPrice);
            }
        }
    }

    public ArrayList<Publication> getBooks() {
        return books;
    }
}
