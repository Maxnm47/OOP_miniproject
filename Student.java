public class Student {
    
    private String name;

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



}
