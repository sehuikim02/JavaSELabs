package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("철수", 100);
        MereClerk mereClerk2 = new MereClerk("영희", 100);
        Manager manager = new Manager("홍길동", 200);
        // 새로운 Employee 객체 생성
        // 자식 mgr = new 자식
        Manager mgr1 = new Manager("둘리", 200, "HR");
        System.out.println(mgr1.getName());
        System.out.println(mgr1.getSalary());
        System.out.println(mgr1.getDept());
        
        // 다형성 (Polymorphism)
        // 자식 mgr2 = new 부모
        Employee mgr2 = new Manager("고길동", 250, "IT");
        System.out.println(mgr2.getName());
        System.out.println(mgr2.getSalary());
        
        // Manager(자식)이 가진 getDept() 메서드 호출 - mgr2 변수로
        Manager mgr3 = (Manager) mgr2;
        System.out.println(mgr3.getDept());
        
        
        // heterogeneous Collection - employee 타입의 배열의 선언
        // emps 변수는 Employee[] 타입, emps[0]는 Employee 타입
        Employee[] emps = new Employee[4];
        emps[0] =  new Manager("고길동", 250, "IT");
        emps[1] =  new Manager("철수", 100, "IT");
        emps[2] =  new Manager("영희", 150, "IT");
        emps[3] =  new Manager("수희", 200, "IT");
        
        System.out.println("현재 월급입니다.");
        printEmployeeInfo(emps);    
        
        for (Employee emp : emps) {
        	emp.manageSalary(10);
        }
        
        System.out.println("급여를 올린 후의 월급입니다.");
        printEmployeeInfo(emps);
    }

	public static void printEmployeeInfo(Employee[] emps) {
		for (Employee emp : emps) {
			// emp가 Manager 객체로부터 만들어진  instance인지를 체크하는 연산자
			if (emp instanceof Manager) {
				System.out.print("관리자의 부서명 = " + ((Manager)emp).getDept() + " ");
			}
        	System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");	 
        }
	}
}