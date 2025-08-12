package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false;
    }

    public void displayCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i).getTitle() + " - " + String.format("%,d", items.get(i).getPrice()) + "��");
            total += items.get(i).getPrice();
        }
        System.out.println("�� ����: " + String.format("%,d", total) + "��");
        System.out.println("���� ���� ����: " + String.format("%,d", calculateDiscountedPrice()) + "��");
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    public void printStatistics() {
        int magCount = 0, novelCount = 0, refCount = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) magCount++;
            else if (item instanceof Novel) novelCount++;
            else if (item instanceof ReferenceBook) refCount++;
        }
        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + refCount + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        cart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
        cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        cart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
        cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("���߿�");
        cart.displayCart();
    }
}
