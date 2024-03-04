package inheritance_primer;

import java.util.ArrayList;

public class Instructor extends Person {

    ArrayList<String> courses;

    public Instructor(int id, String name, String email) {
        super(id, name, email);
        courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "INSTRUCTOR: " + name;
    }
}
