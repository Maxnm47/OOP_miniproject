import java.util.ArrayList;

public class Student {
    
    private String name;
    private ArrayList<String> courses = new ArrayList<>();

    private int courseCount = 0;
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

   
    public void addCourse(String newCourse) {
    if(newCourse != null) {
        courses.add(newCourse);
    }
}


public ArrayList<String> getCourses() {
    // Debug: Check what courses contains before returning
    System.out.println("Debug: courses before returning: " + this.courses);
    return this.courses;
}



}
