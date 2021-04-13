public class Student {

    private final String Sid;
    private final String Sname;
    private final String Sbd;

    public Student(String sid, String sname, String sbd) {
        Sid = sid;
        Sname = sname;
        Sbd = sbd;
    }
    public String getSid() { return Sid; }

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
