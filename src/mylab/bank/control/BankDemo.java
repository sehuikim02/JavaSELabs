package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        SavingsAccount acc1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        CheckingAccount acc2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        SavingsAccount acc3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        acc1.deposit(5000.0);
        try {
            acc2.withdraw(3000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        acc1.applyInterest();

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(acc3.getAccountNumber(), acc2.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.printAllAccounts();

        try {
            acc2.withdraw(6000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            acc2.withdraw(10000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
