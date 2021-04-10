import java.io.IOException;
import java.util.*;


public class Test1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        ArrayList<Student> studentAv = new ArrayList<>();
        ArrayList<Course> courseAv = new ArrayList<>();

        Course c1 = new Course("c001", "Information Technology","12");

        Student s1 = new Student("s001", "Nguyen Chan Phong", "02/01/2000");
        Student s2 = new Student("s002", "Audrey", "23/01/2003");
        studentAv.add(s1);
        studentAv.add(s2);
        courseAv.add(c1);

        Student result1;
        Course result2;

        System.out.println("Enter the student ID: ");
        String studentID = in.nextLine();
        System.out.println("Enter the course ID: ");
        String courseID = in.nextLine();

        for (int i = 0; i < studentAv.size(); i++) {
            if (studentAv.get(i).getSid().equals(studentID)) {
                result1 = studentAv.get(i);
                System.out.println(result1);
            }
        }

        for (int i = 0; i < courseAv.size(); i++) {
            if (courseAv.get(i).getCid().equals(courseID)) {
                result2 = courseAv.get(i);
                System.out.println(result2);
            }
        }

//        c1.enrol(s1);
//        c1.enrol(s2);
//        System.out.println(c1.getStudentList().toString());

    }

    public void searchbyID(String id) {

    }
}
