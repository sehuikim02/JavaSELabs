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
        System.out.printf("Saving(����) ���°� �����Ǿ����ϴ�: %s%n", getAccountInfo(account));
        return account;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�: %s%n", getAccountInfo(account));
        return account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }

    public void transfer(String fromAccountNum, String toAccountNum, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAcc = findAccount(fromAccountNum);
        Account toAcc = findAccount(toAccountNum);
        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccountNum, toAccountNum);
    }

    public void printAllAccounts() {
        System.out.println("\n=== ��� ���� ��� ===");
        for (Account acc : accounts) {
            System.out.println(getAccountInfo(acc));
        }
        System.out.println("===================");
    }

    private String getAccountInfo(Account acc) {
        if (acc instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acc;
            return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%",
                    acc.getAccountNumber(), acc.getOwnerName(), acc.getBalance(), sa.getInterestRate());
        } else if (acc instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) acc;
            return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��",
                    acc.getAccountNumber(), acc.getOwnerName(), acc.getBalance(), ca.getWithdrawalLimit());
        }
        return "";
    }
}
