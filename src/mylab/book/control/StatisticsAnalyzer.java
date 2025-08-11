package mylab.book.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Publication;

public class StatisticsAnalyzer {
    public void analyze(ArrayList<Publication> books) {
        System.out.println("===== 출판물 통계 분석 =====");

        // 1. 타입별 평균 가격
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        for (Publication p : books) {
            String type = p.getClass().getSimpleName();
            count.put(type, count.getOrDefault(type, 0) + 1);
            sum.put(type, sum.getOrDefault(type, 0) + p.getPrice());
        }
        System.out.println("1. 타입별 평균 가격:");
        count.forEach((type, c) -> {
            System.out.printf("   - %s: %,d원%n",
                    type.equals("Novel") ? "소설" : type.equals("Magazine") ? "잡지" : "참고서",
                    sum.get(type) / c);
        });

        // 2. 출판물 유형 분포
        System.out.println("\n2. 출판물 유형 분포:");
        int totalBooks = books.size();
        count.forEach((type, c) -> {
            System.out.printf("   - %s: %.2f%%%n",
                    type.equals("Novel") ? "소설" : type.equals("Magazine") ? "잡지" : "참고서",
                    (c * 100.0 / totalBooks));
        });

        // 3. 2007년에 출판된 비율
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " +
                String.format("%.2f%%",
                        books.stream().filter(b -> b.getPublishDate().getYear() == 2007).count()
                                * 100.0 / totalBooks));
    }
}
