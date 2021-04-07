import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Course {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(isr);


    private String Cid;
    private String Cname;
    private String Credit;

    public Course() {

        this.Cid = "c001";
        this.Cname = "Intro to Programming";
        this.Credit = "12";
        }

    public boolean setCourseInfo() throws IOException {
        System.out.print("Please enter course ID: ");
        Cid = bf.readLine();

        System.out.print("Enter course name: ");
        Cname = bf.readLine();

        System.out.print("Enter course credits: ");
        Credit = bf.readLine();

        return true;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public Course(String cid, String cname, String credit) {
        Cid = cid;
        Cname = cname;
        Credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cid='" + Cid + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Credit='" + Credit + '\'' +
                '}';
    }


}
