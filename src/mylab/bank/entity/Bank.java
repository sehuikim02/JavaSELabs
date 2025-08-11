package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000;
    }

    public SavingsAccount createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        accounts.add(account);
        System.out.printf("Saving(저축) 계좌가 생성되었습니다: %s%n", getAccountInfo(account));
        return account;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("체킹 계좌가 생성되었습니다: %s%n", getAccountInfo(account));
        return account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void transfer(String fromAccountNum, String toAccountNum, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAcc = findAccount(fromAccountNum);
        Account toAcc = findAccount(toAccountNum);
        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccountNum, toAccountNum);
    }

    public void printAllAccounts() {
        System.out.println("\n=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(getAccountInfo(acc));
        }
        System.out.println("===================");
    }

    private String getAccountInfo(Account acc) {
        if (acc instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acc;
            return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",
                    acc.getAccountNumber(), acc.getOwnerName(), acc.getBalance(), sa.getInterestRate());
        } else if (acc instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) acc;
            return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원",
                    acc.getAccountNumber(), acc.getOwnerName(), acc.getBalance(), ca.getWithdrawalLimit());
        }
        return "";
    }
}
