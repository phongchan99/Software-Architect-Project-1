import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Student {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(isr);

    private String Sid;
    private String Sname;
    private String Sbd;

    public Student(String sid, String sname, String sbd) {
        Sid = sid;
        Sname = sname;
        Sbd = sbd;
    }
    public String getSid() {
        return Sid;
    }

    public String getSname() {
        return Sname;
    }

    public String getSbd() {
        return Sbd;
    }

    @Override
    public String toString() {
        return "\n Student{" +
                "Sid='" + Sid + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Sbd='" + Sbd + '\'' +
                "}";
    }
}
