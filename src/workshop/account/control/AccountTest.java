package workshop.account.control;
import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {
		// 1. Account 객체 생성 (기본 생성자 호출)
		Account a = new Account();

		// 1-1. setter 메서드 호출로 값을 대입
		// 고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
		a.setCustId("A1100");
		a.setAcctId("221-22-3477");
		a.deposit(1000);
		
		// 1-2. getter 메서드 호출로 값을 확인
		System.out.println("고객번호 = " + a.getCustId());
		System.out.println("계좌번호 = " + a.getAcctId());
		System.out.println("잔액 = "    + a.getBalance());
		System.out.println("");
		
		// 2. Account 객체 - 오버로딩된 생성자 호출
		Account a2 = new Account("B1200", "331-242-3478", 2000);
		System.out.println("고객번호 = " + a2.getCustId());
		System.out.println("계좌번호 = " + a2.getAcctId());
		System.out.println("잔액 = "    + a2.getBalance());
		System.out.println("");
		
		// 입급
		System.out.println("10000원 입급");
		a2.deposit(10000);
		System.out.println("잔액 = "    + a2.getBalance());
		
		System.out.println("");
		
		System.out.println("10000원 출금");
		
		try {
			a2.withdraw(10000);
			System.out.println("잔액 = " + a2.getBalance());
			System.out.println("5000원 출금");
			a2.withdraw(5000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
