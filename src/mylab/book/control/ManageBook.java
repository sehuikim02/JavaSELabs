package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        if (publication instanceof Magazine) {
            publication.setPrice((int)(currentPrice * 0.6));
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(currentPrice * 0.8));
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(currentPrice * 0.9));
        }
    }

    public static void main(String[] args) {
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i+1) + ". " + publications[i]);
        }

        Publication target = publications[6];
        int beforePrice = target.getPrice();
        System.out.println("\n==== ���� ���� ====");
        System.out.println(target.getTitle() + " ���� �� ����: " + beforePrice + "��");
        modifyPrice(target);
        System.out.println(target.getTitle() + " ���� �� ����: " + target.getPrice() + "��");
        System.out.println("����: " + (beforePrice - target.getPrice()) + "��");

        System.out.println();
        new StatisticsAnalyzer().printStatistics(publications);
    }
}
