package mylab.book.control;

import java.util.ArrayList;
import mylab.book.entity.Publication;

public class ShoppingCart {
    private ArrayList<Publication> cart = new ArrayList<>();

    public void addItem(Publication p) {
        cart.add(p);
        System.out.printf("%s이(가) 장바구니에 추가되었습니다.%n", p.getTitle());
    }

    public void removeItem(String title) {
        cart.removeIf(p -> {
            if (p.getTitle().equals(title)) {
                System.out.printf("%s이(가) 장바구니에서 제거되었습니다.%n", title);
                return true;
            }
            return false;
        });
    }

    public void showCart() {
        System.out.println("====== 장바구니 내용 ======");
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            Publication p = cart.get(i);
            System.out.printf("%d. %s - %,d원%n", i + 1, p.getTitle(), p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("총 가격: %,d원%n", total);
        System.out.printf("할인 적용 가격: %,d원%n", (int)(total * 0.85));
    }

    public void showStatistics() {
        System.out.println("====== 장바구니 통계 ======");
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
        System.out.printf("잡지: %d권%n", magCount);
        System.out.printf("소설: %d권%n", novelCount);
        System.out.printf("참고서: %d권%n", refCount);
        System.out.printf("총 출판물: %d권%n", cart.size());
    }
}
