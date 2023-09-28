public class Group {
        
        private static int groupCount = 0;
        private int groupId;
        private int groupSize;
        private int hoursBooked;
        private String Subject;
        
        public static Group createGroup(String subject) {
            Group group = new Group();
            group.setId(groupCount);
            group.setSubject(subject);
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
            if (this.groupSize >= 6) {
                System.out.println("Group " + this.groupId + " is full");
                return;
            }
            

            for (Student existingStudent : students.getAllItems()) {
                if (existingStudent.getName().equals(student.getName())) {
                    System.out.println("Student is already in group");
                    return;
                }
            }
        
            students.AddToList(student);
            this.groupSize++;
        }

        public void getStudents() {
            for(int i = 0; i < students.getSize(); i++){
                System.out.println(students.getAllItems().get(i).getName());
           }
        }

        
        public void setSubject(String Subject) {
            this.Subject = Subject;
        }

        public String getSubject() {
            return this.Subject;
        }

    
}
