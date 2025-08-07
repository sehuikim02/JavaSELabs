package workshop.oop.flexible;

public class MereClerk extends Employee {
    public MereClerk (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
        super(name, salary);
    }
    /*
     * 오버라이딩 규칙은 부모가 상속해준 메소드의 Signature가 반드시 같아야 함.
     * @Override 어노테이션은 오버라이딩 규칙을 컴파일타임에 체크해준다.
     */
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}