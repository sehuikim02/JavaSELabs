package mylab.student.control;
import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student student = new Student("20251234", "김민수", "컴퓨터공학", 3);
            System.out.println(student.getName() + " / " + student.getMajor()
            					+ " / " + student.getGrade() + "학년");

            // 예외 발생
            System.out.println("5학년으로 변경");
            student.setGrade(5); 

        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
