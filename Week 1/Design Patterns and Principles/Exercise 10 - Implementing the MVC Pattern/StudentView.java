package mvcpattern;

public class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student: ");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}
