package bean;

public class Student {
    private int id;
    private String name;
    private String birthday;
    private String beizhu;
    private int avemark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public int getAvemark() {
        return avemark;
    }

    public void setAvemark(int avemark) {
        this.avemark = avemark;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", avemark=" + avemark +
                '}';
    }
}
