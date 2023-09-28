public class BookingSystem {
    public static void main(String[] args) {
        
        GenericList<Student> students = studentsMaker(12);
        GenericList<Group> groups = groupsMaker("math");
        
        // Display group info
        System.out.println("group1 id" + groups.getAllItems().get(0).getId());
        System.out.println("There is " + Group.getgroupCount() + " groups");
        
        // Adding students to groups
        System.out.println("group adding time");
        System.out.println("");
        
        addStudentToGroup(students.getItem(0), groups.getItem(0));
        addStudentToGroup(students.getItem(1), groups.getItem(0));
        addStudentToGroup(students.getItem(2), groups.getItem(0));
        addStudentToGroup(students.getItem(3), groups.getItem(0));

 
        // Display groups and their members
        getGroupsAndMembers(groups);
        
    }     


    public static void getGroupsAndMembers(GenericList<Group> groups){
        for(int i = 0; i < groups.getSize(); i++){
            System.out.println("group" + groups.getAllItems().get(i).getId() + " members:");
            groups.getAllItems().get(i).getStudents(); 
            System.out.println("");
        }
    }

    public static GenericList<Student> studentsMaker(int count){
        GenericList<Student> students = new GenericList<>();
        for(int i = 0; i < count; i++){ 
            students.AddToList(Student.createStudent("Student " + i));
        }
        return students;
    }

    public static GenericList<Group> groupsMaker(String subject){
        GenericList<Group> groups = new GenericList<>();
        groups.AddToList(Group.createGroup(subject));
        return groups;
    }

 

    public static void addStudentToGroup(Student student, Group group){
        group.addStudent(student);
        student.addCourse(group.getSubject());
    }
}
