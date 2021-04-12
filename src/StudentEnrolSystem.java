import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentEnrolSystem implements StudentEnrolmentManager{
    static Scanner in = new Scanner(System.in);

    static ArrayList<Course> courseAv = new ArrayList();
    static ArrayList<Student> studentAv = new ArrayList();
    static ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();

    static String[] semester = {"2020A", "2020B", "2020C","2021A","2021B","2021C","2022A","2022B","2022C","2023A","2023B","2023C","2024A","2024B","2024C"};
    static ArrayList semesters = new ArrayList(Arrays.asList(semester));

    public static void mainMenu() {
        System.out.println("\n Enrollment System:");
        System.out.println("**********************");
        System.out.println("[1] Enrollment");
        System.out.println("[2] Display one record");
        System.out.println("[3] Display all records");
        System.out.println("[4] Update/Delete an enrolment");
        System.out.println("[5] Export records");
        System.out.println("[6] Printing options");
        System.out.println("[0] Exit");
    }

    public static int getMenuOption() {
        int option;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        option = in.nextInt();
        return option;
    }

    public static String readFile(){
        boolean done = false;
        String fileName = "";
        while (!done) {
            System.out.print("Please enter File Name located in src folder. Leave null to load default file: ");
            fileName = in.nextLine();
            String defaultFile = "default.csv";
            if (!fileName.equals("")) {
                defaultFile = "src/"+fileName;
            }
            String line;
            String splitBy = ",";
            try {
                BufferedReader in = new BufferedReader(new FileReader(defaultFile));

                while ((line = in.readLine()) != null) {

                    boolean sAdded = false, cAdded = false;
                    String[] data = line.split(splitBy);
                    for (Student student : studentAv) {
                        if (student.getSid().equals(data[0])) {
                            sAdded = true;
                            break;
                        }
                    }
                    for (Course course : courseAv) {
                        if (course.getCid().equals(data[3])) {
                            cAdded = true;
                            break;
                        }
                    }
                    if (!sAdded) {
                        studentAv.add(new Student(data[0], data[1], data[2]));
                    }
                    if (!cAdded) {
                        courseAv.add(new Course(data[3], data[4], data[5]));
                    }
                    studentEnrolmentList.add(new StudentEnrolment((new Student(data[0], data[1], data[2])), new Course(data[3], data[4], data[5]), data[6]));
                }
                System.out.println("Successfully read from file.");
                done = true;

            } catch (IOException e) {
                System.out.println("An error occurred. Cannot find File.");
                done=false;
            }
        }
        return fileName;
    }

    public static void main(String[] args) {
        String defaultLink = readFile();
        int opt;
        do {
            mainMenu();
            opt = getMenuOption();
            switch (opt) {
                case 1 -> add();
                case 2 -> getOne();
                case 3 -> getAll();
                case 4 -> update();
                case 5 -> saveFile(defaultLink);
                case 6 -> printing();
                default -> System.out.println("Choice not found");
            }
        }
        while (opt != 0);
    }

    private static void saveFile(String fileName) {
        String defaultFile = "src/default.csv";
        if (!fileName.equals("")) {
            defaultFile = fileName;
        }
        try {
            FileWriter fw = new FileWriter(defaultFile);
            for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                fw.write(studentEnrolment.toString());
            }
            fw.close();
            System.out.println("File exported successfully");
        } catch (IOException e) {
            System.out.println("An error found.");
            e.printStackTrace();
        }
    }


    public static void add() {

        Student result1 = null;
        Course result2 = null;

        System.out.println("List of available students:");
        for (Student student : studentAv) {
            System.out.println(student.getSid() + " " + student.getSname());
        }
        System.out.println("Enter the student ID: ");
        String studentID = in.nextLine();

        for (Student student : studentAv) {
            if (student.getSid().equals(studentID))
                result1 = student;
        }
        if (result1 == null) {
            System.out.println("No student available with given ID.");
            return;
        }

        System.out.println("List of available courses:");
        for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
            System.out.println(studentEnrolment.getCourse().getCid() + " " + studentEnrolment.getCourse().getCname() + " " + studentEnrolment.getCourse().getCredit());
        }

        System.out.println("Enter the course ID: ");
        String courseID = in.nextLine();

        for (Course course : courseAv) {
            if (course.getCid().equals(courseID))
                result2 = course;
        }
        if (result2 == null) {
            System.out.println("No course available with given ID.");
            return;
        }

        System.out.println("Enter the semester: ");
        String Sem = in.nextLine();
        if (!(semesters.contains(Sem))) {
            System.out.println("Not an available semester.");
            return;
        }

        StudentEnrolment record = new StudentEnrolment(result1, result2, Sem);
        if (studentEnrolmentList.contains(record)){
            System.out.println("Enrolment already existed");
            return;
        }
        studentEnrolmentList.add(record);
        System.out.println("Success");
        System.out.println(result1.getSid() + " " + result1.getSname() + ", " + result2.getCid()+ " " + result2.getCname() + ", " + Sem);
    }

        public static void update() {
            Student result1 = null;
            Course result2 = null;
            String chose;

            for (Student student : studentAv){
                System.out.println(student.getSid() + " " + student.getSname());
            }
            System.out.println("Please enter the student ID:");
            String studentID = in.nextLine();

            for (Student student : studentAv) {
                if (student.getSid().equals(studentID))
                    result1 = student;
            }
            if (result1 == null) {
                System.out.println("No student available with given ID.");
                return;
            }
            for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                if (studentEnrolment.getStudent().getSid().equalsIgnoreCase(studentID)) {
                    System.out.println(studentEnrolment.toString());
                }
            }
            System.out.println("Do you want to | [1]Add / [2]Delete | a course? ");
            System.out.println("Please input your select");
            chose = in.nextLine();
            if (chose.equals("1")) {
                for (Course course : courseAv) {
                    System.out.println(course.getCid() + " " + course.getCname());
                }
                System.out.println("Please select the course you want to enrol:");
                String courseID = in.nextLine();

                System.out.println("Please select the semester:");
                String semester = in.nextLine();
                for (Course course : courseAv) {
                    if (course.getCid().equalsIgnoreCase(courseID)) {
                        result2 = course;
                    }
                }
                studentEnrolmentList.add(new StudentEnrolment(result1,result2,semester));
                System.out.println("Updated successfully");

            } else{
                if (chose.equals("2")) {
                    System.out.println("Please enter the course ID you want to delete:");
                    String courseID = in.nextLine();

                    System.out.println("Enter the semester:");
                    String sem = in.nextLine();

                    for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                        if ((studentEnrolment.getCourse().getCid().equalsIgnoreCase(courseID)) && (studentEnrolment.getSemester().equals(sem))) {
                            studentEnrolmentList.remove(studentEnrolment);
                            System.out.println("Successfully deleted course " + courseID + " from " + studentID);
                            break;
                        }
                    }
                    System.out.println("Course removed.");
                }
                else
                    System.out.println("Not an available option.");
            }
        }

        public static void getOne() {
            Student result1 = null;
            Course result2 = null;

            System.out.println("Student list:");
            System.out.println(studentAv.toString());
            System.out.println("Please enter the student ID:");
            String studentID = in.nextLine();

            for (Student student : studentAv) {
                if (student.getSid().equals(studentID)) {
                    result1 = student;
                }
                if (result1 == null) {
                    System.out.println("No student found with given ID.");
                    return;
                }
            }

            System.out.println("Course list:");
            System.out.println(courseAv.toString());
            System.out.println("Please enter the course ID:");
            String courseID = in.nextLine();

            for (Course course : courseAv) {
                if (course.getCid().equals(courseID)) {
                    result2 = course;
                }
                if (result2 == null) {
                    System.out.println("No course found with given ID.");
                    return;
                }
            }
            System.out.println("Please enter the semester:");
            String semester = in.nextLine();
            if (!(semesters.contains(semester))) {
                System.out.println("Not an available semester.");
            }

            for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                if (studentEnrolment.getStudent().getSid().equals(studentID) && studentEnrolment.getCourse().getCid().equals(courseID) && studentEnrolment.getSemester().equalsIgnoreCase(semester)) {
                    System.out.println(studentEnrolment.toString());
                } else {
                    System.out.println("This enrolment is not available, please try again.");
                    return;
                }
            }
    }

        public static void printing() {
            Student result1 = null;
            Course result2 = null;
            String semester;
            String chose;

            System.out.println("""
                    Select option below:
                    [1]Print all courses of 1 student in 1 semester.
                    [2]Print all students of 1 course in 1 semester.
                    [3]Print all courses offered in chosen semester\s""");
            String opt = in.nextLine();
            switch (opt) {
                case "1":
                    System.out.println("List of available students");
                    for (Student student : studentAv) {
                        System.out.println(student.getSid() + " " + student.getSname());
                    }
                    System.out.println("Please enter the student ID:");
                    String studentID = in.nextLine();

                    for (Student student : studentAv) {
                        if (student.getSid().equals(studentID)) {
                            result1 = student;
                        }
                        if (result1 == null) {
                            System.out.println("No student found with given ID.");
                            return;
                        }
                    }
                        System.out.println("Enter the semester:");
                        semester = in.nextLine();

                        for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                            if (studentEnrolment.getStudent().equals(studentID) && (studentEnrolment.getSemester().equals(semester))) {
                                System.out.println(studentEnrolment.toString());
                            }
                        }
                        System.out.println("""
                                Do you want to print the file?
                                [Y]Yes
                                [N]No""");
                        chose = in.nextLine();
                        if (chose.equalsIgnoreCase("Y")) {
                            String defaultFile = "src/Default.csv";
                            try {
                                FileWriter fw = new FileWriter(defaultFile);
                                for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                                    if (studentEnrolment.getStudent().getSid().equals(studentID) && (studentEnrolment.getSemester().equals(semester))) {
                                        fw.write(studentEnrolment.toString());
                                    }
                                }
                                fw.close();
                                System.out.println("File exported successfully");
                            } catch (IOException e) {
                                System.out.println("An error found.");
                                e.printStackTrace();
                            }
                        } else if (chose.equalsIgnoreCase("N"))
                            System.out.println("The process finished");
                        break;

                case "2":
                    System.out.println("List of courses:");
                    System.out.println(courseAv.toString());

                    System.out.println("Please enter the course ID:");
                    String courseID = in.nextLine();

                    for (Course course : courseAv) {
                        if (course.getCid().equals(courseID)) {
                            result2 = course;
                        }
                        if (result2 == null) {
                            System.out.println("No course found with given ID.");
                            return;
                        }
                    }
                        System.out.println("Enter the semester:");
                        semester = in.nextLine();

                    for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                        if (studentEnrolment.getCourse().getCid().equals(courseID) && (studentEnrolment.getSemester().equals(semester))) {
                            System.out.println(studentEnrolment.toString());
                        }
                    }
                    System.out.println("""
                            Do you want to print the file?
                            [1]Yes
                            [2]No""");
                    chose = in.nextLine();
                    if (chose.equals("1")) {
                        String defaultFile = "src/default.csv";
                        try {
                            FileWriter fw = new FileWriter(defaultFile);
                            for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                                if (studentEnrolment.getCourse().getCid().equals(courseID) && (studentEnrolment.getSemester().equals(semester))) {
                                    fw.write(studentEnrolment.toString());
                                }
                            }
                            fw.close();
                            System.out.println("File exported successfully");
                        } catch (IOException e) {
                            System.out.println("An error found.");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("The process finished.");
                    }
                    break;

                case "3":
                    System.out.println("Enter the semester");
                    semester = in.nextLine();

                    for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                        if (studentEnrolment.getSemester().equals(semester)) {
                            System.out.println(studentEnrolment.getCourse().getCid() + " " + studentEnrolment.getCourse().getCname() + " " + studentEnrolment.getCourse().getCredit());
                        }
                    }
                    System.out.println("""
                            Do you want to print the file?
                            [1]Yes
                            [2]No""");
                    chose = in.nextLine();
                    if (chose.equals("1")) {
                        String defaultFile = "src/default.csv";
                        try {
                            FileWriter fw = new FileWriter(defaultFile);
                            for (StudentEnrolment studentEnrolment : studentEnrolmentList) {
                                if (studentEnrolment.getSemester().equals(semester)) {
                                    fw.write(studentEnrolment.toString());
                                }
                            }
                            fw.close();
                            System.out.println("File exported successfully.");
                        } catch (IOException e) {
                            System.out.println("An error found.");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("The process finished.");
                    }
                    break;
                default:
                    System.out.println("The choice is not available");
                    break;
            }
        }

        public static void getAll() {
            if (studentEnrolmentList.isEmpty()) {
                System.out.println("No records to be shown.");
            }
            System.out.println("List of enrolments");
            System.out.println(studentEnrolmentList.toString());
        }
    }
