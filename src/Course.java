import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Course {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(isr);

    private String Cid;
    private String Cname;
    private String Credit;

    public Course(String cid, String cname, String credit) {
        Cid = cid;
        Cname = cname;
        Credit = credit;
    }
    public String getCid() {
        return Cid;
    }

    public String getCname() {
        return Cname;
    }

    public String getCredit() {
        return Credit;
    }

    @Override
    public String toString() {
        return "\n Course{" +
                "Cid='" + Cid + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Credit='" + Credit + '\'' +
                '}';
    }
}
