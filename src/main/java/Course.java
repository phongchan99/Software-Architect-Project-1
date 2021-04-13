public class Course {

    private final String Cid;
    private final String Cname;
    private final String Credit;

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
