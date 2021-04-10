import java.io.IOException;
import java.util.*;

public class StudentEnrolment {
    static Scanner in = new Scanner(System.in);

    Student student = new Student();
    Course course = new Course();

    //static Course c[] = new Course[100];
    static List<Course> courseAv = new ArrayList();
    static List<Student> studentAv = new ArrayList();


    static String[] semester = {"2021A", "2021B", "2021C", "2022A", "2022B", "2022C", "2023A", "2023B", "2023C"};
    static List<String> semesters = new ArrayList(Arrays.asList(semester));

    static ArrayList<String> studentEnrolment = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        Course c1 = new Course("c001", "Information Technology","12");
        courseAv.add(c1);
        Student s1 = new Student("s001", "Nguyen Chan Phong", "02/01/2000");
        Student s2 = new Student("s002", "Audrey", "23/01/2003");
        studentAv.add(s1);
        studentAv.add(s2);


        Course course = new Course();
        Student student = new Student();

        int opt = 0;
        do {
            mainMenu();
            opt = getMenuOption();
            switch (opt) {
                case 1 -> add();
                case 2 -> addNewCourse();
                case 3 -> getAll();
                case 4 -> update();
                case 5 -> getOne();
                default -> System.out.println("Choice not found");
            }
        }
        while (opt != 6);
    }

    public static boolean addNewCourse() throws IOException {
        System.out.print("\n [Course Info] \n");
        System.out.print("Please enter course ID: ");

        String courseID = in.nextLine();
        for (Course course : courseAv) {
            if (course.getCid().equals(courseID)) {
                System.out.println("Course already existed.");
                return false;
            }
        }
        System.out.print("Enter course name: ");
        String courseName = in.nextLine();

        System.out.print("Enter course credits: ");
        String credit = in.nextLine();

        courseAv.add(new Course(courseID, courseName, credit));
        System.out.println("Added successfully");
        System.out.println(courseAv);
        return false;
    }


    public static boolean add() {

        Student result1 = null;
        Course result2 = null;
        
        System.out.println("Enter the student ID: ");
        String studentID = in.nextLine();

        System.out.println("Enter the course ID: ");
        String courseID = in.nextLine();


        System.out.println("Enter the semester: ");
        String Sem = in.nextLine();


        if (!(semesters.contains(Sem))) {
            System.out.println("Not a valid semester.");
            return false;
        }

        for (int i = 0; i < studentAv.size(); i++) {
            if (studentAv.get(i).getSid().equals(studentID))
                result1 = studentAv.get(i);
        }
        if (result1 == null) {
            System.out.println("No student available with given ID.");
            return false;
        }


        for (int i = 0; i < courseAv.size(); i++) {
            if (courseAv.get(i).getCid().equals(courseID))
                result2 = courseAv.get(i);
        }

        if (result2.getStudentList().contains(result1)) {
            System.out.println("Existed");
            return false;
        } else {

            result2.getStudentList().add(result1);
            result1.getCourseList().add(result2);
            System.out.println("Success");
        }
        System.out.println("Course contain: " + result2.getStudentList().toString());
        return true;
    }



        public boolean delete() {
            return false;
        }


        public static boolean update() {
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
                return false;
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
                return false;
            }
            return true;
        }


        public static boolean getOne() {
            Course result = null;
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
            Course course = new Course();
            Student student = new Student();

            System.out.println(courseAv);
            System.out.println(studentAv);
        }
    }
