package mylab.book.control;

import java.util.ArrayList;
import mylab.book.entity.Publication;

public class ManageBook {
    private ArrayList<Publication> books = new ArrayList<>();

    public void addBook(Publication p) {
        books.add(p);
    }

    public void listBooks() {
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, books.get(i).toString());
        }
    }

    public void adjustPrice(String title, double rate) {
        for (Publication p : books) {
            if (p.getTitle().equals(title)) {
                int oldPrice = p.getPrice();
                System.out.printf("%s 변경 전 가격: %,d원%n", title, oldPrice);
                int newPrice = (int) (oldPrice * rate);
                p.setPrice(newPrice);
                System.out.printf("%s 변경 후 가격: %,d원%n", title, newPrice);
                System.out.printf("차액: %,d원%n", oldPrice - newPrice);
            }
        }
    }

    public ArrayList<Publication> getBooks() {
        return books;
    }
}
