package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        SavingsAccount acc1 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        CheckingAccount acc2 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        SavingsAccount acc3 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        acc1.deposit(5000.0);
        try {
            acc2.withdraw(3000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        acc1.applyInterest();

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(acc3.getAccountNumber(), acc2.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        bank.printAllAccounts();

        try {
            acc2.withdraw(6000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            acc2.withdraw(10000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
