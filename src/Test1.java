import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Test1 {
    public static void main(String args[]) throws Exception {
        ArrayList<Student> studentAv = new ArrayList<>();
        ArrayList<Course> courseAv = new ArrayList<>();
        String semester[] = new String[100];

        String line = "";
        String splitBy = ",";

        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\phongchan99\\Downloads\\default.csv"));
        while ((line = in.readLine()) != null) {
            String[] student = line.split(splitBy);
            studentAv.add(new Student(student[0], student[1], student[2]));
            courseAv.add(new Course(student[3], student[4], student[5]));
//            System.out.println("Student [ID]= " + student[0] + ", name= " + student[1] + ", birthdate =" + student[2] + ", course ID= " + student[3] + ", course name= " + student[4] + ", course credit= " + student[5] + ", semester= " + student[6]);
        }
        System.out.println(studentAv + "\n");
        System.out.println(courseAv + "\n");


    }
}
