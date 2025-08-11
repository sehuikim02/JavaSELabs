package mylab.book.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Publication;

public class StatisticsAnalyzer {
    public void analyze(ArrayList<Publication> books) {
        System.out.println("===== ���ǹ� ��� �м� =====");

        // 1. Ÿ�Ժ� ��� ����
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        for (Publication p : books) {
            String type = p.getClass().getSimpleName();
            count.put(type, count.getOrDefault(type, 0) + 1);
            sum.put(type, sum.getOrDefault(type, 0) + p.getPrice());
        }
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        count.forEach((type, c) -> {
            System.out.printf("   - %s: %,d��%n",
                    type.equals("Novel") ? "�Ҽ�" : type.equals("Magazine") ? "����" : "����",
                    sum.get(type) / c);
        });

        // 2. ���ǹ� ���� ����
        System.out.println("\n2. ���ǹ� ���� ����:");
        int totalBooks = books.size();
        count.forEach((type, c) -> {
            System.out.printf("   - %s: %.2f%%%n",
                    type.equals("Novel") ? "�Ҽ�" : type.equals("Magazine") ? "����" : "����",
                    (c * 100.0 / totalBooks));
        });

        // 3. 2007�⿡ ���ǵ� ����
        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " +
                String.format("%.2f%%",
                        books.stream().filter(b -> b.getPublishDate().getYear() == 2007).count()
                                * 100.0 / totalBooks));
    }
}
