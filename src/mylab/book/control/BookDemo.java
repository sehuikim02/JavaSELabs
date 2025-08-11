package mylab.book.control;

import mylab.book.entity.*;

public class BookDemo {
    public static void main(String[] args) {
        ManageBook manager = new ManageBook();

        manager.addBook(new Magazine("마이크로소프트", "매월", 328, 9900, "2007-10-01"));
        manager.addBook(new Magazine("경영과컴퓨터", "매월", 316, 9000, "2007-10-03"));
        manager.addBook(new Novel("빠삐용", "베르나르베르베르", "현대소설", 396, 9800, "2007-07-01"));
        manager.addBook(new Novel("남한산성", "김훈", "대하소설", 383, 11000, "2007-04-14"));
        manager.addBook(new ReferenceBook("실용주의프로그래머", "소프트웨어공학", 496, 25000, "2007-01-14"));
        manager.addBook(new Novel("소년이온다", "한강", "장편소설", 216, 15000, "2014-05-01"));
        manager.addBook(new Novel("작별하지않는다", "한강", "장편소설", 332, 15120, "2021-09-09"));

        manager.listBooks();

        System.out.println("\n==== 가격 변경 ====");
        manager.adjustPrice("작별하지않는다", 0.8);

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

        cart.removeItem("빠삐용");
        cart.showCart();
    }
}
