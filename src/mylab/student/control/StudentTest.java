package mylab.student.control;
import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student student = new Student("20251234", "��μ�", "��ǻ�Ͱ���", 3);
            System.out.println(student.getName() + " / " + student.getMajor()
            					+ " / " + student.getGrade() + "�г�");

            // ���� �߻�
            System.out.println("5�г����� ����");
            student.setGrade(5); 

        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
