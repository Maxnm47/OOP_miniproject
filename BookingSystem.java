import java.util.Scanner;

public class BookingSystem {
    public static void main(String[] args) {
        
        GenericList<Student> students = studentsMaker(12);
        GenericList<Group> groups = new GenericList<>();
        GenericList<Room> rooms = roomMaker(2);  
        Scanner scanner = new Scanner(System.in);
                System.out.println("Select Role:");
        System.out.println("1: Administrator");
        //System.out.println("2: Student");
        
        int role = Integer.parseInt(scanner.nextLine().trim());

        while (true) {
            if (role == 1) {
                // Administrator Menu
                System.out.println("------");
                System.out.println("Administrator: Choose an option:");
                System.out.println("1: Create a new group");
                System.out.println("2: Add a student to a group");
                System.out.println("3: Display group info");
                System.out.println("4: Book a room for a group");
                System.out.println("5: Show all group room statuses");
                System.out.println("6: Exit");


                int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
    case 1:
        System.out.println("Enter the subject for the new group:");
        String subject = scanner.nextLine().trim();
        groups.AddToList(Group.createGroup(subject));
        System.out.println("Group created. Current groups:");
        getGroups(groups);  // Show all groups after creating a new one
        break;
    case 2:
        // New case to add a student to a group
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

        System.out.println("Available Groups:");  // Show available groups for selection
        getGroups(groups);

        System.out.println("Enter the group ID to add the student to:");
        int groupId = Integer.parseInt(scanner.nextLine().trim());
        Group group = groups.getItem(groupId);

        if (group == null) {
            System.out.println("Group not found.");
            continue;
        }

        addStudentToGroup(student, group);
        break;
    case 3:
        showAllGroupsAndMembers(groups);  // Display all groups and their members
        break;
    case 4:
    System.out.println("Enter the group ID to reserve a room for:");
    // make this show all the groups
    getGroups(groups);

    groupId = Integer.parseInt(scanner.nextLine().trim());
    group = groups.getItem(groupId);

    if (group == null) {
        System.out.println("Group not found.");
        continue;
    }
    getRoomsAndReservations(rooms);
    System.out.println("Enter the room ID to reserve:");

    int roomId = Integer.parseInt(scanner.nextLine().trim());
    Room room = rooms.getItem(roomId);

    if (room == null) {
        System.out.println("Room not found.");
        continue;
    }

    showAvailableTimesForRoom(room);
    int startTimeIndex = Integer.parseInt(scanner.nextLine().trim()) - 1; // subtract 1 for zero-based index

    // Check if the selected time slot is already reserved
    if (room.isTimeSlotReserved(startTimeIndex)) {
        System.out.println("Invalid time slot: Already reserved.");
        break;
    }

    System.out.println("Enter the number of hours to reserve (max 4):");
    int hours = Integer.parseInt(scanner.nextLine().trim());

    if (group.reserveRoom(room, startTimeIndex, hours)) {
        System.out.println("Room reserved successfully!");
        room.getSchedule();  // Refresh the schedule
        showAvailableTimesForRoom(room);  // Display the updated schedule
    } else {
        System.out.println("Failed to reserve room.");
    }

    showAvailableTimesForRoom(room);
    break;
    
    case 5:
        for (int i = 0; i < rooms.getSize(); i++) {
        room = rooms.getItem(i);
        showAvailableTimesForRoom(room);
    }
        break;
    case 6:
        scanner.close();
        return;
    default:
        System.out.println("Invalid choice.");
    }
        } 

             else {
                System.out.println("Invalid role selected.");
                scanner.close();
                return;
            }
        }
    }

    
    public static void getGroups(GenericList<Group> groups){
        System.out.println("------");
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

    public static GenericList<Room> roomMaker(int count){
        GenericList<Room> rooms = new GenericList<>();
        for(int i = 0; i < count; i++){ 
            rooms.AddToList(new Room(i));
        }
        return rooms;
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
   public static void getRoomsAndReservations(GenericList<Room> rooms) {
    for (int i = 0; i < rooms.getSize(); i++) {
        Room room = rooms.getItem(i);
        System.out.println("Room ID: " + room.getRoomId());
        
        boolean[] schedule = room.getSchedule();
        for (int j = 0; j < schedule.length; j++) {
            String timeSlot = (j + 8) + ":00 - " + (j + 9) + ":00";
            String reserved = schedule[j] ? "Reserved" : "Available";
            System.out.println(timeSlot + ": " + reserved);
        }
        System.out.println("------");
    }
} 
public static void showAvailableTimesForRoom(Room room) {
    System.out.println("Available Times for Room ID: " + room.getRoomId());
    Reservation[] availableHours = room.getAvailableHours();
    for (int j = 0; j < availableHours.length; j++) {
        String timeSlot = (j + 8) + ":00 - " + (j + 9) + ":00";
        if (availableHours[j] != null) {
            System.out.println((j+1) + ": " + timeSlot + ": Reserved by group " + availableHours[j].getGroupId());
        } else {
            System.out.println((j+1) + ": " + timeSlot + ": Available");
        }
    }
    System.out.println("------");
}

}
