import java.util.Scanner;

public class BookingSystem {
    public static void main(String[] args) {
        
        GenericList<Student> students = studentsMaker(12);
        GenericList<Group> groups = new GenericList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Create a new group");
            System.out.println("2: Add a student to a group");
            System.out.println("3: Display group info");
            System.out.println("4: Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the remaining newline character
            
            switch (choice) {
                case 1:
                    System.out.println("Enter the subject for the new group:");
                    String subject = scanner.nextLine().trim();
                    groups.AddToList(Group.createGroup(subject));
                    break;
                    
                case 2:
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.getSize(); i++) {
                        System.out.println(students.getItem(i).getName());
                    }

                    System.out.println("Enter the name of the student:");
                    String studentName = scanner.nextLine().trim();
                    Student student = findStudentByName(students, studentName);
                    
                    if (student == null) {
                        System.out.println("Student not found.");
                        continue;
                    }
                    
                    System.out.println("Available Groups:");
                    getGroupsAndMembers(groups);
                    
                    System.out.println("Enter the group ID(number) to add the student to:");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character
                    Group group = groups.getItem(groupId);
                    
                    if (group == null) {
                        System.out.println("Group not found.");
                        continue;
                    }
                    
                    addStudentToGroup(student, group);
                    break;
                    
                case 3:
                    getGroupsAndMembers(groups);
                    break;
                    
                case 4:
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    
    public static void getGroupsAndMembers(GenericList<Group> groups){
        for(int i = 0; i < groups.getSize(); i++){
            System.out.println("group " + groups.getAllItems().get(i).getId() +" subject "+ groups.getAllItems().get(i).getSubject() + " members:");
            groups.getAllItems().get(i).getStudents(); 
            System.out.println("");
        }
    }

    public static void showAllGroupsAndMembers(GenericList<Group> groups) {
        if(groups.getSize() == 0) {
            System.out.println("No groups available.");
            return;
        }

        for(int i = 0; i < groups.getSize(); i++) {
            System.out.println("Group ID: " + groups.getAllItems().get(i).getId());
            System.out.println("Group Subject: " + groups.getAllItems().get(i).getSubject());
            System.out.println("Members:");
            groups.getAllItems().get(i).getStudents();
            System.out.println("------");
        }
    }
    
    public static GenericList<Student> studentsMaker(int count){
        GenericList<Student> students = new GenericList<>();
        for(int i = 0; i < count; i++){ 
            students.AddToList(Student.createStudent("Student " + i));
        }
        return students;
    }

    public static void addStudentToGroup(Student student, Group group){
        if (student.getCourses().contains(group.getSubject())) {
            System.out.println("Student already in a group with that subject");
            return;
        }

        boolean courseAdded = student.addCourse(group.getSubject());
        if (courseAdded) {
            group.addStudent(student);
        } else {
            System.out.println("Failed to add student to group");
        }
    }

    public static Student findStudentByName(GenericList<Student> students, String name) {
        for (int i = 0; i < students.getSize(); i++) {
            if (students.getItem(i).getName().equals(name)) {
                return students.getItem(i);
            }
        }
        return null;
    }
}
