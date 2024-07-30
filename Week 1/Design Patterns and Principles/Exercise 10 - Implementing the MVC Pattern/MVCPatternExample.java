package mvcpattern;

public class MVCPatternExample {
    public static void main(String[] args) {
        
        Student student = new Student("Inaya", 1, "A");


        StudentView view = new StudentView();

        
        StudentController controller = new StudentController(student, view);

        
        controller.updateView();

        
        controller.setStudentName("Jason");
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
