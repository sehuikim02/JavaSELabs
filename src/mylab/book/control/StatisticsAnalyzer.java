package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        else if (pub instanceof Magazine) return "����";
        else if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
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

        System.out.println("===== ���ǹ� ��� �м� =====");
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for (String type : avgPrice.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrice.get(type)) + "��");
        }

        System.out.println("\n2. ���ǹ� ���� ����:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        for (String type : dist.keySet()) {
            System.out.println("   - " + type + ": " + df.format(dist.get(type)) + "%");
        }

        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " +
                           df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
