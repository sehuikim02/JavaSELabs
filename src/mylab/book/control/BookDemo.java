package mylab.book.control;

import mylab.book.entity.*;

public class BookDemo {
    public static void main(String[] args) {
        ManageBook manager = new ManageBook();

        manager.addBook(new Magazine("����ũ�μ���Ʈ", "�ſ�", 328, 9900, "2007-10-01"));
        manager.addBook(new Magazine("�濵����ǻ��", "�ſ�", 316, 9000, "2007-10-03"));
        manager.addBook(new Novel("���߿�", "����������������", "����Ҽ�", 396, 9800, "2007-07-01"));
        manager.addBook(new Novel("���ѻ꼺", "����", "���ϼҼ�", 383, 11000, "2007-04-14"));
        manager.addBook(new ReferenceBook("�ǿ��������α׷���", "����Ʈ�������", 496, 25000, "2007-01-14"));
        manager.addBook(new Novel("�ҳ��̿´�", "�Ѱ�", "����Ҽ�", 216, 15000, "2014-05-01"));
        manager.addBook(new Novel("�ۺ������ʴ´�", "�Ѱ�", "����Ҽ�", 332, 15120, "2021-09-09"));

        manager.listBooks();

        System.out.println("\n==== ���� ���� ====");
        manager.adjustPrice("�ۺ������ʴ´�", 0.8);

        System.out.println();
        new StatisticsAnalyzer().analyze(manager.getBooks());

        System.out.println();
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(manager.getBooks().get(0));
        cart.addItem(manager.getBooks().get(1));
        cart.addItem(manager.getBooks().get(2));
        cart.addItem(manager.getBooks().get(3));
        cart.addItem(manager.getBooks().get(4));

        cart.showCart();
        cart.showStatistics();

        cart.removeItem("���߿�");
        cart.showCart();
    }
}
