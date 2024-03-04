package inheritance_primer;

public class Student extends Person {
    private String major;


    public Student(int id, String name, String email, String major) {
        super(id, name, email);
        this.major = major;
    }
}
