package mylab.student.entity;
import mylab.student.exception.InvalidGradeException;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;
    
    // default constructor ����
 	public Student() {
 		System.out.println("�⺻������ ȣ���");
 	}
    
    // Constructor Overloading (������ �ߺ� ����)
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    // grade ���� �߻�
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�.");
        }
    }
}
