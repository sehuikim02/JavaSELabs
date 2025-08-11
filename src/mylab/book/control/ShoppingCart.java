package mylab.book.control;

import java.util.ArrayList;
import mylab.book.entity.Publication;

public class ShoppingCart {
    private ArrayList<Publication> cart = new ArrayList<>();

    public void addItem(Publication p) {
        cart.add(p);
        System.out.printf("%s��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.%n", p.getTitle());
    }

    public void removeItem(String title) {
        cart.removeIf(p -> {
            if (p.getTitle().equals(title)) {
                System.out.printf("%s��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.%n", title);
                return true;
            }
            return false;
        });
    }

    public void showCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            Publication p = cart.get(i);
            System.out.printf("%d. %s - %,d��%n", i + 1, p.getTitle(), p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("�� ����: %,d��%n", total);
        System.out.printf("���� ���� ����: %,d��%n", (int)(total * 0.85));
    }

    public void showStatistics() {
        System.out.println("====== ��ٱ��� ��� ======");
        int novelCount = 0, magCount = 0, refCount = 0;
        for (Publication p : cart) {
            String type = p.getClass().getSimpleName();
            switch (type) {
                case "Novel":
                    novelCount++;
                    break;
                case "Magazine":
                    magCount++;
                    break;
                case "ReferenceBook":
                    refCount++;
                    break;
            }
        }
        System.out.printf("����: %d��%n", magCount);
        System.out.printf("�Ҽ�: %d��%n", novelCount);
        System.out.printf("����: %d��%n", refCount);
        System.out.printf("�� ���ǹ�: %d��%n", cart.size());
    }
}
