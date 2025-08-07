package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager manager = new Manager("ȫ�浿", 200);
        // ���ο� Employee ��ü ����
        // �ڽ� mgr = new �ڽ�
        Manager mgr1 = new Manager("�Ѹ�", 200, "HR");
        System.out.println(mgr1.getName());
        System.out.println(mgr1.getSalary());
        System.out.println(mgr1.getDept());
        
        // ������ (Polymorphism)
        // �ڽ� mgr2 = new �θ�
        Employee mgr2 = new Manager("��浿", 250, "IT");
        System.out.println(mgr2.getName());
        System.out.println(mgr2.getSalary());
        
        // Manager(�ڽ�)�� ���� getDept() �޼��� ȣ�� - mgr2 ������
        Manager mgr3 = (Manager) mgr2;
        System.out.println(mgr3.getDept());
        
        
        // heterogeneous Collection - employee Ÿ���� �迭�� ����
        // emps ������ Employee[] Ÿ��, emps[0]�� Employee Ÿ��
        Employee[] emps = new Employee[4];
        emps[0] =  new Manager("��浿", 250, "IT");
        emps[1] =  new Manager("ö��", 100, "IT");
        emps[2] =  new Manager("����", 150, "IT");
        emps[3] =  new Manager("����", 200, "IT");
        
        System.out.println("���� �����Դϴ�.");
        printEmployeeInfo(emps);    
        
        for (Employee emp : emps) {
        	emp.manageSalary(10);
        }
        
        System.out.println("�޿��� �ø� ���� �����Դϴ�.");
        printEmployeeInfo(emps);
    }

	public static void printEmployeeInfo(Employee[] emps) {
		for (Employee emp : emps) {
			// emp�� Manager ��ü�κ��� �������  instance������ üũ�ϴ� ������
			if (emp instanceof Manager) {
				System.out.print("�������� �μ��� = " + ((Manager)emp).getDept() + " ");
			}
        	System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");	 
        }
	}
}