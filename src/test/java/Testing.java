import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {
    private static Student student;
    private static Course course;
    private static StudentEnrolSystem studentEnrolmentList;

    @BeforeEach
    public void setUp(){
        studentEnrolmentList = new StudentEnrolSystem();
    }

    @Test
    public void testEnrollIdWhenAdd(){
       Student result1 = new Student("s001","Phong","25/12/1999");
       Course result2 = new Course("c001","Sadi","12");
       String sem = "2021A";
       studentEnrolmentList.equals( new StudentEnrolment(result1,result2,sem));
       assertEquals("s001", result1.getSid());

   }
    @Test
    public void testEnrollStudentNameWhenAdd(){
        Student result1 = new Student("s001","Phong","25/12/1999");
        Course result2 = new Course("c001","Sadi","12");
        String sem = "2021A";
        studentEnrolmentList.equals( new StudentEnrolment(result1,result2,sem));
        assertEquals("Phong", result1.getSname());
    }
    @Test
    public void testEnrollCourseNameWhenAdd(){
        Student result1 = new Student("s001","Phong","25/12/1999");
        Course result2 = new Course("c001","Sadi","12");
        String sem = "2021A";
        studentEnrolmentList.equals( new StudentEnrolment(result1,result2,sem));
        assertEquals("Sadi", result2.getCname());
    }
    @Test
    public void testEnrollCourseNameWhenUpdate(){
        Student result1 = new Student("s001","Phong","25/12/1999");
        Course result2 = new Course("c001","Sadi","12");
        String sem = "2021A";
        studentEnrolmentList.equals( new StudentEnrolment(result1,result2,sem));
        assertEquals("Sadi", result2.getCname());
    }
}
