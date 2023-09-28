public class Group {
        
        private static int groupCount = 0;
        private int groupId;
        private int groupSize;
        private int hoursBooked;
        private String Subject;
        
        public static Group createGroup() {
            Group group = new Group();
            group.setId(groupCount);
            groupCount++;
            return group;
        }
        
        public void setId(int groupId) {
            this.groupId = groupId;
        }
        
        public int getId() {
            return groupId;
        } 

        public static int getgroupCount() {
            return groupCount;
        }

        GenericList<Student> students = new GenericList<>();

        public void addStudent(Student student) {
            if(this.groupSize <= 6){
            students.AddToList(student);
            this.groupSize++;
            }
            else{
                System.out.println("Group is full");
            }
        }

        public void getStudents() {
            for(int i = 0; i < students.getSize(); i++){
                System.out.println(students.getAllItems().get(i).getName());
           }


        }

    
}
