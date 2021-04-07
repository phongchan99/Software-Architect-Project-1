import java.io.IOException;
import java.util.*;

public class StudentEnrolment {
    static Scanner in = new Scanner(System.in);

    //static Course c[] = new Course[100];
    static List<String> courseList = new ArrayList<String>();
    static Student s[] = new Student[100];


    static int CourseCount;
    static int StudentCount;

    static String[] semester = {"2021A", "2021B", "2021C", "2022A", "2022B", "2022C", "2023A", "2023B", "2023C"};
    static List<String> semesters = new ArrayList(Arrays.asList(semester));

    static ArrayList<String> studentEnrolment = new ArrayList<>();
    static Iterator<String> it = studentEnrolment.iterator();

    public static void mainMenu() {
        System.out.println("\n Enrollment System:");
        System.out.println("**********************");
        System.out.println("[1] Enrollment");
        System.out.println("[2] Add new course");
        System.out.println("[3] Get information");
        System.out.println("[4] Display all records");
        System.out.println("[5] Exit");
    }

    public static int getMenuOption() {
        int option;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        option = in.nextInt();
        return option;
    }

    public static void main(String args[]) throws IOException {

        Course course = new Course();
        CourseCount = 0;
        StudentCount = 0;

        courseList.add("c001");
        int opt = 0;
        do {
            mainMenu();
            opt = getMenuOption();
            switch (opt) {
                case 1:
                    add();
                    break;
                case 2:
                    addNewCourse();
                    break;
                case 3:
                    getAll();
                    break;
                default:
                    System.out.println("Choice not found");
            }
        }
        while (opt != 5);
    }

    public static boolean addNewCourse() throws IOException {
        Course course = new Course();
        System.out.print("\n [Course Info] \n");
        course.setCourseInfo();
        if (!(courseList.isEmpty())) {
            if (courseList.contains(course.getCid())) {
                System.out.println("Course already existed");
                return false;
            }
            }
            courseList.add(course.getCid() + " " + course.getCname() + " " + course.getCredit());
            CourseCount++;
            System.out.println("Course added successfully");
        return true;
    }

    public static boolean add() {
        System.out.println("Enter the student ID: ");
        String Sid = in.nextLine();

        System.out.println("Enter the course ID: ");
        String Cid = in.nextLine();

        System.out.println("Enter the semester: ");
        String Sem = in.nextLine();
        if (semesters.contains(Sem)) {
            studentEnrolment.add(Sid + " enrolled in " + Cid + " in semester " + Sem);
            System.out.println("Successfully enrolled");
            return true;
        } else
            System.out.println("Not a valid semester.");
            return false;
        }



        public boolean delete() {
            return false;
        }


        public boolean update() {

            return false;
        }


        public boolean getOne() {

            return false;
        }


        public static void getAll() {
            System.out.println(studentEnrolment);
            System.out.println(courseList);
        }
    }
