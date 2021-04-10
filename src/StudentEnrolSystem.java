import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentEnrolSystem {
    static Scanner in = new Scanner(System.in);


    static ArrayList<Course> courseAv = new ArrayList();
    static ArrayList<Student> studentAv = new ArrayList();
    static ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();


    static String[] semester = {"2021A", "2021B", "2021C", "2022A", "2022B", "2022C", "2023A", "2023B", "2023C"};
    static List<String> semesters = new ArrayList(Arrays.asList(semester));


    public static void mainMenu() {
        System.out.println("\n Enrollment System:");
        System.out.println("**********************");
        System.out.println("[1] Enrollment");
        System.out.println("[2] Add new course");
        System.out.println("[3] Get information");
        System.out.println("[4] Update student's records");
        System.out.println("[5] Display one course's records");
        System.out.println("[6] Exit");
    }

    public static int getMenuOption() {
        int option;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        option = in.nextInt();
        return option;
    }

    public static void readFile(String link) throws Exception {
        String line;
        String splitBy = ",";
        boolean sDup = false;
        boolean cDup = false;
        try {
            BufferedReader in = new BufferedReader(new FileReader(link));

            while ((line = in.readLine()) != null) {
                String[] data = line.split(splitBy);

                for (Student student : studentAv) {
                    if (student.getSid().equals(data[0])) {
                        sDup = true;
                        break;
                    }
                }
                for (Course course : courseAv) {
                    if (course.getCid().equals(data[3])) {
                        cDup = true;
                        break;
                    }
                }
                if (!sDup) {
                    studentAv.add(new Student(data[0], data[1], data[2]));
                }
                if (!cDup) {
                    System.out.println("Course access");
                    courseAv.add(new Course(data[3], data[4], data[5]));
                    System.out.println(courseAv);
                }
                studentEnrolmentList.add(new StudentEnrolment(new Student(data[0], data[1], data[2]), new Course(data[3], data[4], data[5]), data[6]));


            }
            System.out.println("Read the file successfully.");

        } catch (IOException e) {
            System.out.println("Found error, cannot load the file.");
        }
    }

    public static void main(String[] args) throws Exception {
        String defaultLink = "default.csv";

        Course c1 = new Course("c001", "Information Technology","12");
        Student s1 = new Student("s001", "Nguyen Chan Phong", "02/01/2000");
        Student s2 = new Student("s002", "Audrey", "23/01/2003");

        System.out.println("Enter the enrolment file's name? If no leave the field empty.");
        String link = in.nextLine();
        if (link.equals("")) {
            readFile(defaultLink);
        }
        else
            readFile(link);

        int opt = 0;
        do {
            mainMenu();
            opt = getMenuOption();
            switch (opt) {
                case 1 -> add();
                case 2 -> delete();
                case 3 -> getAll();
                case 4 -> update();
                case 5 -> getOne();
                default -> System.out.println("Choice not found");
            }
        }
        while (opt != 7);
    }


    public static void add() {

        Student result1 = null;
        Course result2 = null;
        
        System.out.println("Enter the student ID: ");
        String studentID = in.nextLine();

        for (int i = 0; i < studentAv.size(); i++) {
            if (studentAv.get(i).getSid().equals(studentID))
                result1 = studentAv.get(i);
        }
        if (result1 == null) {
            System.out.println("No student available with given ID.");
            return;
        }

        System.out.println("Enter the course ID: ");
        String courseID = in.nextLine();

        for (int i = 0; i < courseAv.size(); i++) {
            if (courseAv.get(i).getCid().equals(courseID))
                result2 = courseAv.get(i);
        }
        if (result2 == null) {
            System.out.println("No course available with given ID.");
            return;
        }

        if (result2.getStudentList().contains(result1)) {
            System.out.println("Existed");
            return;
        } else {

        System.out.println("Enter the semester: ");
        String Sem = in.nextLine();


        if (!(semesters.contains(Sem))) {
            System.out.println("Not a valid semester.");
            return;
        }

            result2.getStudentList().add(result1);
            result1.getCourseList().add(result2);
            System.out.println("Success");
        }
        System.out.println("Course contain: " + result2.getStudentList().toString());
    }



        public static void delete() {
        }


        public static void update() {
            Student result1 = null;
            Course result2 = null;
            int opt = 0;
            String chose;

            System.out.println("Please enter the student ID:");
            String studentID = in.nextLine();

            for (int i = 0; i < studentAv.size(); i++) {
                if (studentAv.get(i).getSid().equals(studentID))
                    result1 = studentAv.get(i);
            }
            if (result1 == null) {
                System.out.println("No student available with given ID.");
                return;
            }
            System.out.println(result1.getSid() + "'s course lists: " + result1.getCourseList().toString());
            System.out.println("Do you want to | [1]Add / [2]Delete | a course? ");
            System.out.println("Please input your select");
            chose = in.nextLine();
            if (chose.equals("1")) {
                add();
            } else{
                if (chose.equals("2")) {
                    System.out.println("Please enter the course ID you want to delete:");
                    String courseID = in.nextLine();

                    for (int i = 0; i < courseAv.size(); i++) {
                        if (courseAv.get(i).getCid().equals(courseID)) {
                            result2 = courseAv.get(i);
                            result1.getCourseList().remove(result2);
                            result2.getStudentList().remove(result1);
                            System.out.println("Course removed.");
                        }
                    }
                }
                else
                    System.out.println("Not an available option.");
            }
        }


        public static boolean getOne() {
            Course result;
            System.out.println("Please enter the course ID:");
            String courseID = in.nextLine();

            for (int i = 0; i < courseAv.size(); i++) {
                if (courseAv.get(i).getCid().equals(courseID)) {
                    result = courseAv.get(i);
                    System.out.println(result.getStudentList().toString());
                    return true;
                }
            }
            return false;
        }


        public static void getAll() {
            System.out.println(studentEnrolmentList.toString() + "\n");
            System.out.println(studentAv);
            System.out.println(courseAv);
        }
    }
