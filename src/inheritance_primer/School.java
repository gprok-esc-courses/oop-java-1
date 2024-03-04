package inheritance_primer;

public class School {
    public static void main(String[] args) {
        Student s = new Student(1, "Mike",
                "mike@school.test", "Computing");
        Instructor i = new Instructor(2, "John",
                "john@instr.school.test");

        Person p = s;
        System.out.println(p);
        p = i;
        System.out.println(p);
    }
}
