package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPrice = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrice.put(type, totalPrice.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgPrice = new HashMap<>();
        for (String type : totalPrice.keySet()) {
            avgPrice.put(type, totalPrice.get(type) / (double) count.get(type));
        }
        return avgPrice;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        int total = publications.length;
        for (String type : count.keySet()) {
            distribution.put(type, (count.get(type) * 100.0) / total);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) count++;
        }
        return (count * 100.0) / publications.length;
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for (String type : avgPrice.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrice.get(type)) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        for (String type : dist.keySet()) {
            System.out.println("   - " + type + ": " + df.format(dist.get(type)) + "%");
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " +
                           df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
