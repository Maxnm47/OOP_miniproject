class BookingSystem {
    public static void main(String[] args) {
        
        GenericList<Student> students = studentsMaker(12);
 
        GenericList<Group> groups = groupsMaker(2);
                
        System.out.println("group1 id" + groups.getAllItems().get(0).getId());

        System.out.println("There is " + Group.getgroupCount()+ " groups");

        System.out.println("group adding time");

        System.out.println("");
        groups.getItem(0).addStudent(students.getItem(0));
        groups.getItem(0).addStudent(students.getItem(1));
        groups.getItem(0).addStudent(students.getItem(2));
        groups.getItem(0).addStudent(students.getItem(3));

        groups.getItem(1).addStudent(students.getItem(4));
        groups.getItem(1).addStudent(students.getItem(5));
        groups.getItem(1).addStudent(students.getItem(6));
        groups.getItem(1).addStudent(students.getItem(7));
        
        groups.AddToList(Group.createGroup());
        

        groups.getItem(2).addStudent(students.getItem(8));
        groups.getItem(2).addStudent(students.getItem(9));
        groups.getItem(2).addStudent(students.getItem(10));
        groups.getItem(2).addStudent(students.getItem(11));

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
    public static GenericList<Group> groupsMaker(int count){

        GenericList<Group> groups = new GenericList<>();
        for(int i = 0; i < count; i++){ 
            groups.AddToList(Group.createGroup());
        }
        return groups;
    }
}
