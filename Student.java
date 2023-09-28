import java.util.ArrayList;

public class Student {
    
    private String name;
    private ArrayList<String> courses = new ArrayList<>();

    public static Student createStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   
    public boolean addCourse(String newCourse) {
    if (newCourse == null) {
        return false;
    }
    if (courses.contains(newCourse)) {
        System.out.println("Student already enrolled in this course.");
        return false;
    }
    if (courses.size() >= 5) {
        System.out.println("Student already has 5 courses");
        return false;
    }
    courses.add(newCourse);
    return true;
}



public ArrayList<String> getCourses() {
    return this.courses;
}



}
