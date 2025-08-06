package workshop.account.control;
import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {
		// 1. Account ��ü ���� (�⺻ ������ ȣ��)
		Account a = new Account();

		// 1-1. setter �޼��� ȣ��� ���� ����
		// ����ȣ : ��A1100��, ���¹�ȣ : ��221-22-3477��, �ܾ� : 100000
		a.setCustId("A1100");
		a.setAcctId("221-22-3477");
		a.deposit(1000);
		
		// 1-2. getter �޼��� ȣ��� ���� Ȯ��
		System.out.println("����ȣ = " + a.getCustId());
		System.out.println("���¹�ȣ = " + a.getAcctId());
		System.out.println("�ܾ� = "    + a.getBalance());
		System.out.println("");
		
		// 2. Account ��ü - �����ε��� ������ ȣ��
		Account a2 = new Account("B1200", "331-242-3478", 2000);
		System.out.println("����ȣ = " + a2.getCustId());
		System.out.println("���¹�ȣ = " + a2.getAcctId());
		System.out.println("�ܾ� = "    + a2.getBalance());
		System.out.println("");
		
		// �Ա�
		System.out.println("10000�� �Ա�");
		a2.deposit(10000);
		System.out.println("�ܾ� = "    + a2.getBalance());
		
		System.out.println("");
		
		System.out.println("10000�� ���");
		
		try {
			a2.withdraw(10000);
			System.out.println("�ܾ� = " + a2.getBalance());
			System.out.println("5000�� ���");
			a2.withdraw(5000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
