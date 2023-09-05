package Model;

public class Student {

    private long idStudent;
    private String name;
    private String age;
    private EGender Egender;
    private String address;
    private float mediumScore;

    public Student() {
    }

    public Student(long idStudent, String name, String age, EGender egender, String address, float mediumScore) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        Egender = egender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public long getStudentID() {
        return idStudent;
    }

    public void setStudentID(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public EGender getEgender() {
        return Egender;
    }

    public void setEgender(EGender egender) {
        Egender = egender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s\n", this.idStudent, this.name, this.age, Egender, this.address, this.mediumScore);
    }
}
