public class StudentEnrolment {
    Student student;
    Course course;
    String semester;

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return student.getSid() +
                "," + student.getSname() +
                "," + student.getSbd() +
                "," + course.getCid() +
                "," + course.getCname() +
                "," + course.getCredit() +
                "," + semester + "\n" ;
    }
}
